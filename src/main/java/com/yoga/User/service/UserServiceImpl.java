package com.yoga.User.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;
import com.yoga.User.controller.request.CreateCompanyRequest;
import com.yoga.User.controller.request.CreateUserRequest;
import com.yoga.User.controller.response.Response;
import com.yoga.User.controller.response.UserResponse;
import com.yoga.User.model.*;
import com.yoga.User.repositories.*;
import com.yoga.User.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.yoga.User.util.MapperUtil.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WebClientUtil webClientUtil;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyUserRepository companyUserRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CustomRepository customRepository;

    @Override
    public CreateUserRequest getCompanyUser(String userId) {
        CompanyUser cu = findUserById(userId);
        return cu != null ? getCompanyUserDetails(cu).get() : null;
    }

    @Override
    public Response createCompanyUser(CreateUserRequest createUserRequest, Function<String, Boolean> function) {
        String result =  function.apply(createUserRequest.getUserId()) ?
                "User Exists" : createUser(createUserRequest);
        return new Response().setResult(result);
    }

    @Override
    public Role getRole(String roleName) {
        Predicate predicate = QRole.role.name.eq(roleName);
        return getRoleDetails().apply(predicate).orElse(null);
    }

    @Override
    public List<UserResponse> getAllUsers(String companyCode) {
        Company co = getCompany(companyCode);
        List<CompanyUser> users = getAllUsersForCid(co.getId());
        Map<Long, Contact> contactMap = users.stream()
                .map(u -> (getContact().apply(u.getContactId()).get()))
                .collect(Collectors.toMap(cn -> cn.getId(), Function.identity()));
        return users.stream()
                .filter(u -> (contactMap.containsKey(u.getContactId())))
                .map(u -> (getUserResponse(u, contactMap.get(u.getContactId())).get()))
                .collect(Collectors.toList());
    }

    @Override
    public Response updateCompanyUser(String userId, CreateUserRequest createUserRequest, Function<String, Boolean> function) {
        String result = function.apply(userId) ? updateUser(createUserRequest) : "User Not Exists";
        return new Response().setResult(result);
    }

    @Override
    public Response deleteUser(String userId, Function<String, Boolean> function) {
        String result = function.apply(userId) ? deleteUser(userId) : "User Not Exists";
        return new Response().setResult(result);
    }

    private Supplier<CreateUserRequest> getCompanyUserDetails(CompanyUser cu) {
        Contact contact = getContact().apply(cu.getContactId()).orElse(null);
        return () -> mapUserToUserReq(cu, contact);
    }

    private Function<Long, Optional<Contact>> getContact() {
        return contactRepository :: findById;
    }

    private Function<Predicate, Optional<CompanyUser>> findUser() {
        return companyUserRepository :: findOne;
    }

    private String createUser(CreateUserRequest createUserRequest) {
         Contact cn = createContact(createUserRequest);
         CompanyUser cu = getCompanyUserDetails(createUserRequest,cn.getId(),false).get();
         cu = createCompanyUser().apply(cu);
         return cu != null ? "User Created" : "Not Created";
    }

    private Contact createContact(CreateUserRequest createUserRequest) {
        Contact cn = getContactDetails(createUserRequest).get();
        return createContact().apply(cn);
    }

    private Function<Predicate, Optional<Company>> getCompanyByCode() {
        return companyRepository :: findOne;
    }

    private Function<Predicate, Optional<Role>> getRoleDetails() {
        return roleRepository :: findOne;
    }

    private Supplier<Contact> getContactDetails(CreateUserRequest createUserRequest) {
        return () -> mapperToContact(createUserRequest);
    }

    private Function<Contact,Contact> createContact() {
        return contactRepository :: save;
    }

    private Supplier<CompanyUser> getCompanyUserDetails(CreateUserRequest createUserRequest,
                                                        final long contactId, boolean update) {
        if(!update) {
            createUserRequest
                    .setPassword(webClientUtil.invokeSecurityForPwd(createUserRequest.getPassword()).get())
                    .setCompanyId(getCompany(createUserRequest.getCompanyCode()).getId())
                    .setRoleId(getRole(createUserRequest.getRoleName()).getId())
                    .setContactId(contactId);
        }
        return () -> mapperToCompanyUser(createUserRequest);
    }

    private Function<CompanyUser,CompanyUser> createCompanyUser() {
        return companyUserRepository :: save;
    }
    @Override
    public Company getCompany(final String companyCode) {
        Predicate predicate = QCompany.company.companyCode.eq(companyCode);
        return getCompanyByCode().apply(predicate).orElse(null);
    }

    @Override
    public Response createCompany(CreateCompanyRequest createCompanyRequest, Function<String, Boolean> function) {
        String result = function.apply(createCompanyRequest.getCompanyCode()) ? "Company Exists" :
                                                        createCompany(createCompanyRequest);
        return new Response().setResult(result);
    }

    @Override
    public Response createRoles(String roles) throws JsonProcessingException {
        Role roles1 = createRoleDet().apply(new Role().setName(roles));
        String result = roles1 != null ? "Roles Created" : "Failed";
        return new Response().setResult(result);
    }

    private Function<Predicate, Iterable<CompanyUser>> getAllUsersFun() {
        return companyUserRepository :: findAll;
    }

    private List<CompanyUser> getAllUsersForCid(final long companyId) {
        Predicate predicate = QCompanyUser.companyUser.companyId.eq(companyId);
        return StreamSupport.stream(getAllUsersFun().apply(predicate).spliterator(), false)
                .collect(Collectors.toList());
    }

    private Supplier<UserResponse> getUserResponse(CompanyUser cu, Contact co) {
        return () -> mapperToUserRes(cu, co);
    }

    private String updateUser(CreateUserRequest createUserRequest) {
        CompanyUser companyUser = findUserById(createUserRequest.getUserId());
        Contact co = getContact().apply(companyUser.getContactId()).get();
        companyUser = getCompanyUserDetails(createUserRequest, co.getId(), true).get();
        updateCompanyUserDetails().apply(companyUser);
        return "Updated";
    }

    private CompanyUser findUserById(final String userId) {
        Predicate predicate = QCompanyUser.companyUser.userId.eq(userId);
        return findUser().apply(predicate).orElse(null);
    }

    private String deleteUser(final String userId) {
        CompanyUser companyUser = findUserById(userId);
        Contact co = getContact().apply(companyUser.getContactId()).get();
        deleteCompanyUser().accept(companyUser);
        deleteContact().accept(co);
        return "User Deleted";
    }

    private Consumer<CompanyUser> deleteCompanyUser() {
        return companyUserRepository :: delete;
    }

    private Consumer<Contact> deleteContact() {
        return contactRepository :: delete;
    }

    private Function<CompanyUser, Long> updateCompanyUserDetails() {
        return customRepository :: updateCompanyUser;
    }

    private String createCompany(CreateCompanyRequest createCompanyRequest) {
        Contact co = createContact(createCompanyRequest);
        Company company = createCompanyDetails(createCompanyRequest, co.getId());
        return company != null ? "Company Created" : "Failed";
    }

    private Supplier<Contact> getContactDetails(CreateCompanyRequest createCompanyRequest) {
        return () -> mapperToContact(createCompanyRequest);
    }

    private Contact createContact(CreateCompanyRequest createCompanyRequest) {
        Contact co = getContactDetails(createCompanyRequest).get();
        return createContact().apply(co);
    }

    private Supplier<Company> getCompanyDetails(CreateCompanyRequest createCompanyRequest) {
        return () -> mapperToCompany(createCompanyRequest);
    }

    private Company createCompanyDetails(CreateCompanyRequest createCompanyRequest, final long contactId) {
        Company co = getCompanyDetails(createCompanyRequest).get();
        co.setContactId(contactId);
        return co = createCom().apply(co);
    }

    private Function<Company, Company> createCom() {
        return companyRepository :: save;
    }

    private Function<Role, Role> createRoleDet() {
        return roleRepository :: save;
    }
}
