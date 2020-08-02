package com.genetics.qmslogApi.service;

import com.genetics.qmslogApi.model.User;
import com.genetics.qmslogApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User createUser(User user){
//        user.setFirstname(user.getFirstname());
//        user.setSurname(user.getSurname());
//        user.setPassword(user.getPassword());
//        user.setRole(user.getRole());
//        user.setBranch(user.getBranch());
        System.out.println(user);
        return userRepository.save(user);
    }


}
