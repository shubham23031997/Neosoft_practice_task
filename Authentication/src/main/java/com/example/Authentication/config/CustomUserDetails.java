package com.example.Authentication.config;

import com.example.Authentication.entity.UserCredential;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetails implements UserDetails {
    UserCredential userCredential = new UserCredential();
    private String name;
    private String password;
    private String roles;

    public CustomUserDetails(String name, String password, String roles) {
        //super(username, password, authorities);
        this.name = userCredential.getName();
        this.password = userCredential.getPassword();
        this.roles = userCredential.getRoles();
    }

    public CustomUserDetails(UserCredential userCredential) {
    }

//    public CustomUserDetails(UserCredential userCredential) {
//        this.name = userCredential.getName();
//        this.password = userCredential.getPassword();
//    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(userCredential.getRoles());
//        return List.of(simpleGrantedAuthority);
//        //return null;
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Extract roles from the 'roles' field and convert them to SimpleGrantedAuthority objects
        String[] roleArray = roles.split(",");
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roleArray) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.trim())); // Prefix roles with "ROLE_" as a convention
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
