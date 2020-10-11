package com.genetics.qmslogApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.genetics.qmslogApi.security.SecurityConstant.PASSWORD_STRENGTH;

@Configuration
public class PasswordConfig {

   @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder(PASSWORD_STRENGTH);
   }
}
