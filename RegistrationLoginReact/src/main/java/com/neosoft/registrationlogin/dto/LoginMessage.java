package com.neosoft.registrationlogin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginMessage {

    String message;
    Boolean status;

}
