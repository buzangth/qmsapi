package com.genetics.qmslogApi.controller;

import com.genetics.qmslogApi.model.User;
import com.genetics.qmslogApi.repository.UserRepository;
import com.genetics.qmslogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User registerNewUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
