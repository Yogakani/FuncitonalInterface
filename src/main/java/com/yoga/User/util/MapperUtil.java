package com.yoga.User.util;

import com.yoga.User.controller.request.CreateCompanyRequest;
import com.yoga.User.controller.request.CreateUserRequest;
import com.yoga.User.controller.response.UserResponse;
import com.yoga.User.model.Company;
import com.yoga.User.model.CompanyUser;
import com.yoga.User.model.Contact;

public class MapperUtil {

    public static CreateUserRequest mapUserToUserReq(CompanyUser cu, Contact co) {
        return new CreateUserRequest()
                .setId(cu.getId())
                .setUserId(cu.getUserId())
                .setFirstName(cu.getFirstName())
                .setLastName(cu.getLastName())
                .setEmail(cu.getEmail())
                .setCompanyId(cu.getCompanyId())
                .setRoleId(cu.getRoleId())
                .setAddress(co.getAddress())
                .setCity(co.getCity())
                .setCountry(co.getCountry())
                .setZipCode(co.getZipCode())
                .setContactId(co.getId());
    }

    public static Contact mapperToContact(CreateUserRequest createUserRequest) {
        return (Contact) new Contact()
                .setAddress(createUserRequest.getAddress())
                .setCity(createUserRequest.getCity())
                .setCountry(createUserRequest.getCountry())
                .setZipCode(createUserRequest.getZipCode())
                .setCreatedBy(1L)
                .setEditedBy(-1L)
                .setCreateDate(GenericHelper.getCurrentDate())
                .setModifiedDate(GenericHelper.getCurrentDate());
    }

    public static CompanyUser mapperToCompanyUser(CreateUserRequest createUserRequest) {
        return (CompanyUser) new CompanyUser()
                .setUserId(createUserRequest.getUserId())
                .setPassword(createUserRequest.getPassword())
                .setFirstName(createUserRequest.getFirstName())
                .setLastName(createUserRequest.getLastName())
                .setEmail(createUserRequest.getEmail())
                .setCompanyId(createUserRequest.getCompanyId())
                .setRoleId(createUserRequest.getRoleId())
                .setContactId(createUserRequest.getContactId())
                .setCreatedBy(1L)
                .setEditedBy(-1L)
                .setCreateDate(GenericHelper.getCurrentDate())
                .setModifiedDate(GenericHelper.getCurrentDate());
    }

    public static UserResponse mapperToUserRes(CompanyUser cu, Contact co) {
        return new UserResponse()
                .setId(cu.getId())
                .setUserId(cu.getUserId())
                .setFirstName(cu.getFirstName())
                .setLastName(cu.getLastName())
                .setEmail(cu.getEmail())
                .setCompanyId(cu.getCompanyId())
                .setRoleId(cu.getRoleId())
                .setAddress(co.getAddress())
                .setCity(co.getCity())
                .setCountry(co.getCountry())
                .setZipCode(co.getZipCode())
                .setContactId(co.getId());
    }

    public static Contact mapperToContact(CreateCompanyRequest createCompanyRequest) {
        return (Contact) new Contact()
                .setAddress(createCompanyRequest.getAddress())
                .setCity(createCompanyRequest.getCity())
                .setCountry(createCompanyRequest.getCountry())
                .setZipCode(createCompanyRequest.getZipCode())
                .setCreatedBy(1L)
                .setEditedBy(-1L)
                .setCreateDate(GenericHelper.getCurrentDate())
                .setModifiedDate(GenericHelper.getCurrentDate());
    }

    public static Company mapperToCompany(CreateCompanyRequest createCompanyRequest) {
        return new Company()
                .setName(createCompanyRequest.getName())
                .setCompanyCode(createCompanyRequest.getCompanyCode())
                .setLogo(createCompanyRequest.getLogo());
    }

}
