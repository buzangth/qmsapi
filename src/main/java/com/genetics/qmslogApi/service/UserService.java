package com.genetics.qmslogApi.service;

import com.genetics.qmslogApi.exception.UserIdException;
import com.genetics.qmslogApi.model.User;
import com.genetics.qmslogApi.repository.UserRepository;
//import com.genetics.qmslogApi.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public User createUser(User user){

        try{
            System.out.println(user);
            user.setUsername(user.getUsername());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);

        }catch (Exception ex){
            throw  new UserIdException("User Id'" + user.getUsername() + "'username already exist");
        }
    }
}
