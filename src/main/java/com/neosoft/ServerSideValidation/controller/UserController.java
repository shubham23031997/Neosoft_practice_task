package com.neosoft.ServerSideValidation.controller;

import com.neosoft.ServerSideValidation.dto.UserDto;
import com.neosoft.ServerSideValidation.model.User;
import com.neosoft.ServerSideValidation.utility.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private final UserValidator userValidator;

    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else {
            // Logic to save the user if validation passes
            return ResponseEntity.ok("User created successfully");
        }
    }

    private UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setExpiryAfter(user.getExpiryAfter());
        userDto.setExpiryAfterOrEqual(user.getExpiryAfterOrEqual());
        userDto.setExpiryBefore(user.getExpiryBefore());
       // userDto.setSalary(user.getSalary());
        userDto.setDate(user.getDate());
        userDto.setYearOfBirth(user.getYearOfBirth());
        userDto.setExpiryBeforeOrEqual(user.getExpiryBeforeOrEqual());
        userDto.setTermsAndCondition(user.isTermsAndCondition());
        return userDto;
    }
}

