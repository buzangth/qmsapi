package com.genetics.qmslogApi.controller;

import com.genetics.qmslogApi.model.Teller;
import com.genetics.qmslogApi.model.User;
import com.genetics.qmslogApi.repository.UserRepository;
import com.genetics.qmslogApi.service.MapValidationServiceError;
import com.genetics.qmslogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/users")
@RestController
@CrossOrigin(
        origins = "*"
)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MapValidationServiceError mapValidationServiceError;


    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/")
    public String logIn(){
        return "log";
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap!= null) return errorMap;
        User user1 = userService.createUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }

}
