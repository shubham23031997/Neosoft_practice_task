package com.example.Authentication.config;

import com.example.Authentication.entity.UserCredential;
import com.example.Authentication.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // Load user details including roles from your database
        Optional<UserCredential> userCredential = repository.findByName(name);

        if (userCredential == null) {
            throw new UsernameNotFoundException("User not found with username: " + name);
        }
        // Extract roles and convert them to Spring Security authorities
        String[] rolesArray = userCredential.get().getRoles().split(",");
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : rolesArray) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.trim())); // Prefix roles with "ROLE_" as a convention
        }

        // Create and return a UserDetails object with the loaded user details and authorities
        return User.builder()
                .username(userCredential.get().getName())
                .password(userCredential.get().getPassword())
                .authorities(authorities)
                .build();
    }

  /*  @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //here we're checking user is present or not with help of username
        Optional<UserCredential> credential = repository.findByName(username);
        //here return type is userDetails, so we have to convert credentials object to userDetails
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name:" + username));
    }*/
}
