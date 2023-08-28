package com.example.Authentication.service;

import com.example.Authentication.entity.UserCredential;
import com.example.Authentication.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserCredentialRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JWTService jwtService;

    public String saveUser(UserCredential userCredential) {
        //here we can not save password directly in db so need to becript it by using Auth-config class
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        repository.save(userCredential);
        return "user added to the system successfully";
    }

    public String generateToken(String userName) {
        return jwtService.generateToken(userName);
    }

    public void validate(String token) {
        jwtService.validateToken(token);
    }
}
