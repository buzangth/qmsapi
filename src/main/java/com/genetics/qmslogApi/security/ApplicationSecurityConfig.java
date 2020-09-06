package com.genetics.qmslogApi.security;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;


//        @Autowired
//    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .cors()
                .and()
                .csrf().disable()
                //.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                 //.and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*","/html/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//      UserDetails thabo = User.builder()
//                .username("thbusang@gmail.com")
//                .password(passwordEncoder.encode("12345"))
//                .roles("ADMIN")
//                .build();
//
//      return new InMemoryUserDetailsManager(thabo);
//    }
}
