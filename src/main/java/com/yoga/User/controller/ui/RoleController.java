package com.yoga.User.controller.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yoga.User.controller.response.Response;
import com.yoga.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<Response> createRole(final String roles) throws JsonProcessingException {
        Response response = userService.createRoles(roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
