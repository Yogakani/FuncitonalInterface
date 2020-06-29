package com.yoga.User.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCompanyRequest {
    private String name;
    private String companyCode;
    private String logo;
    private String address;
    private String city;
    private String country;
    private long zipCode;
}
