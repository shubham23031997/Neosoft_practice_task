package com.example.Authentication.controller;

import com.example.Authentication.entity.UserCredential;
import com.example.Authentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    //A.M. is used for only allow user which are present in db not
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return authService.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredential userCredential) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getName(), userCredential.getPassword()));
        //here authentication manager directly not able to talk to db so he needs userDetailsService
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(userCredential.getName());
        } else {
            throw new RuntimeException("invalid access");
        }
        //return authService.generateToken(userCredential.getName());
    }

    //here we can use dto class by passing instead of only username we can pass username and password
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validate(token);
        return "token is valid";
    }
}
