package com.neosoft.registrationlogin.service;

import com.neosoft.registrationlogin.dto.EmployeeDTO;
import com.neosoft.registrationlogin.dto.LoginDTO;
import com.neosoft.registrationlogin.dto.LoginMessage;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMessage loginEmployee(LoginDTO loginDTO);

}
