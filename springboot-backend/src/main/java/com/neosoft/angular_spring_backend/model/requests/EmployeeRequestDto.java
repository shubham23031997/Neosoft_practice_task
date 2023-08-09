package com.neosoft.angular_spring_backend.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private String emailId;
    private String birthdate;

}
