package com.neosoft.registrationlogin.controller;

import com.neosoft.registrationlogin.dto.EmployeeDTO;
import com.neosoft.registrationlogin.dto.LoginDTO;
import com.neosoft.registrationlogin.dto.LoginMessage;
import com.neosoft.registrationlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


   @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {

        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}