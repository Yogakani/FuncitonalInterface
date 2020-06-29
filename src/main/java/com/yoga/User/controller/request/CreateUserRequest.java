package com.yoga.User.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String companyCode;
    private String roleName;
    private String address;
    private String city;
    private String country;
    private long zipCode;
    private long companyId;
    private long roleId;
    private long contactId;
}
