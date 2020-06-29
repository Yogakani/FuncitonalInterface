package com.yoga.User.controller.ui;

import com.yoga.User.controller.request.CreateCompanyRequest;
import com.yoga.User.controller.response.Response;
import com.yoga.User.model.Company;
import com.yoga.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/company")
public class CompanyController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createCompany(@RequestBody CreateCompanyRequest createCompanyRequest) {
        Response res = userService.createCompany(createCompanyRequest, this::checkCompanyExists);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    private boolean checkCompanyExists(final String companyCode) {
        Company co = userService.getCompany(companyCode);
        return co != null ? true : false;
    }
 }
