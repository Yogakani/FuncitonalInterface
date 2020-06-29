package com.yoga.User.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yoga.User.controller.request.CreateCompanyRequest;
import com.yoga.User.controller.request.CreateUserRequest;
import com.yoga.User.controller.response.Response;
import com.yoga.User.controller.response.UserResponse;
import com.yoga.User.model.Company;
import com.yoga.User.model.Role;

import java.util.List;
import java.util.function.Function;

public interface UserService {
    CreateUserRequest getCompanyUser(final String userId);
    Response createCompanyUser(CreateUserRequest createUserRequest, Function<String, Boolean> function);
    Role getRole(final String roleName);
    List<UserResponse> getAllUsers(final String companyCode);
    Response updateCompanyUser(String userId, CreateUserRequest createUserRequest, Function<String,Boolean> function);
    Response deleteUser(String userId, Function<String, Boolean> function);
    Company getCompany(final String companyCode);
    Response createCompany(CreateCompanyRequest createCompanyRequest, Function<String, Boolean> function);
    Response createRoles(final String roles) throws JsonProcessingException;
}
