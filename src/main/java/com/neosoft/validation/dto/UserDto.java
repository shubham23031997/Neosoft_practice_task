package com.neosoft.validation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String name;
    private String username;
    private String email;
    private String password;
    private boolean termsAndCondition;
    private String expiryAfter;
    private String expiryAfterOrEqual;
    private String expiryBefore;
    private String expiryBeforeOrEqual;
    private String date;
    private String salary;
    private String yearOfBirth;
}
