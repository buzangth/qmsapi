package com.genetics.qmslogApi.controller;


import com.genetics.qmslogApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/teller/")
public class TellerController {

    @Autowired
    UserRepository userRepository;
}
