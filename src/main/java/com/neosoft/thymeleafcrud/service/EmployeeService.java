package com.neosoft.thymeleafcrud.service;

import com.neosoft.thymeleafcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
}