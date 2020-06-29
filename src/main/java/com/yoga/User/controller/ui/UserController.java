package com.yoga.User.controller.ui;

import com.yoga.User.controller.request.CreateUserRequest;
import com.yoga.User.controller.response.Response;
import com.yoga.User.controller.response.UserResponse;
import com.yoga.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<Response> createUser(@RequestBody CreateUserRequest createUserRequest) {
        Response userResponse =  userService.createCompanyUser(createUserRequest, this::checkUserExists);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    private boolean checkUserExists(final String userId) {
        CreateUserRequest request = userService.getCompanyUser(userId);
        return (request != null && request.getId() > 0)  ? true : false;
    }

    @GetMapping(value = "/getAllUsers/{code}")
    public ResponseEntity<List<UserResponse>> getAllUsers(@PathVariable("code") String companyCode) {
        List<UserResponse> userRes = userService.getAllUsers(companyCode);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<Response> updateUser(@RequestBody CreateUserRequest createUserRequest,
                                               @PathVariable("userId") String userId) {
        Response userResponse = userService.updateCompanyUser(userId, createUserRequest, this::checkUserExists);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<Response> deleteUser(@PathVariable("userId") String userId) {
        Response userResponse = userService.deleteUser(userId, this::checkUserExists);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
