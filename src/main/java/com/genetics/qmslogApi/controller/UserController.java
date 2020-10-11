package com.genetics.qmslogApi.controller;

import com.genetics.qmslogApi.model.User;
import com.genetics.qmslogApi.payload.JWTLoginSuccessResponse;
import com.genetics.qmslogApi.payload.LoginRequest;
import com.genetics.qmslogApi.repository.UserRepository;
import com.genetics.qmslogApi.security.JWTTokenProvider;
import com.genetics.qmslogApi.service.MapValidationServiceError;
import com.genetics.qmslogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.genetics.qmslogApi.security.SecurityConstant.TOKEN_PREFIX;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapValidationServiceError mapValidationServiceError;

    @Autowired
    private JWTTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping(path = "/getUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    @PostMapping(path = "/createUser")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap!= null) return errorMap;
        User user1 = userService.createUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }
}
