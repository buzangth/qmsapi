package com.genetics.qmslogApi.security;

import com.genetics.qmslogApi.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.genetics.qmslogApi.security.SecurityConstant.EXPIRATION_TIME;
import static com.genetics.qmslogApi.security.SecurityConstant.SECRET;

@Component
public class JWTTokenProvider {

    public String generateToken(Authentication authentication){

        User user = (User)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expireDate = new Date(now.getTime() + EXPIRATION_TIME);

        String userId = Integer.toString(user.getId());

        Map<String,Object> clams = new HashMap<>();
        clams.put("id", (Integer.toString(user.getId())));
        clams.put("username",user.getUsername());
        clams.put("role",user.getRole());


        return Jwts.builder()
                .setSubject(userId)
                .setClaims(clams)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,SECRET).compact();
    }
}
