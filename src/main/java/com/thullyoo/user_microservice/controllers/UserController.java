package com.thullyoo.user_microservice.controllers;

import com.thullyoo.user_microservice.entities.user.User;
import com.thullyoo.user_microservice.entities.user.UserRequest;
import com.thullyoo.user_microservice.entities.user.UserResponse;
import com.thullyoo.user_microservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody  @Valid UserRequest userRequest){

        UserResponse userResponse = userService.registerUser(userRequest);

        return ResponseEntity.ok(userResponse);
    }
}
