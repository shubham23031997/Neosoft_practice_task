package com.neosoft.validation.controller;

import com.neosoft.validation.dto.UserDto;
import com.neosoft.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/validate")
    public ResponseEntity<String> validateUserData(@RequestBody UserDto userDto) {
        Map<String, String> rules = defineValidationRules();
        boolean isValid = userService.validateUser(userDto, rules);
        if (isValid) {
            return ResponseEntity.ok("User data is valid!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User data validation failed!");
        }
    }

    private Map<String, String> defineValidationRules() {
        Map<String, String> rules = new HashMap<>();
        rules.put("name", "required|max:50|alpha");
        rules.put("username", "required|min:15");
        rules.put("email", "required|email");
        rules.put("password", "required");
        rules.put("termsAndCondition", "accepted");
        rules.put("expiryAfter", "after:12-02-2023");
        rules.put("expiryAfterOrEqual", "after_or_equal:12-02-2023");
//        rules.put("alpha", "alpha");
//        rules.put("alpha_dash", "alpha_dash");
//        rules.put("alpha_num", "alpha_num");
//        rules.put("array", "array");
        rules.put("expiryBefore", "before:12-02-2023");
        rules.put("expiryBeforeOrEqual", "before_or_equal:12-02-2023");
//        rules.put("between", "between:10,200");
//        rules.put("boolean", "boolean");
        rules.put("date", "date");
//        rules.put("digits", "digits:21");
        rules.put("salary", "required|regex:^(?!0\\.00)\\d{1,3}(,\\d{3})*(\\.\\d\\d)?$");
        rules.put("yearOfBirth", "required|regex:^(19|20)\\d{2}$");
//        rules.put("digits_between", "min:0");
        return rules;
    }
}