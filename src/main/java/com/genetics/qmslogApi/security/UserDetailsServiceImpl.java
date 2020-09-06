package com.genetics.qmslogApi.security;

import com.genetics.qmslogApi.model.User;
import com.genetics.qmslogApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;
import java.util.Set;

import static com.genetics.qmslogApi.security.ApplicationUserRole.*;
@Service
@CrossOrigin
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet< >();
        grantedAuthorities.add(new SimpleGrantedAuthority(ADMIN.name()));
        grantedAuthorities.add(new SimpleGrantedAuthority(BRANCH_MANAGER.name()));
        grantedAuthorities.add(new SimpleGrantedAuthority(TELLER.name()));
        //grantedAuthorities.add(new SimpleGrantedAuthority(BRANCH_MANAGER.getGrantedAuthorities()));
        //System.out.println(grantedAuthorities);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()),
                grantedAuthorities);

    }
}
