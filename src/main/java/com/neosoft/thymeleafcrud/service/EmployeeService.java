package com.neosoft.thymeleafcrud.service;

import com.neosoft.thymeleafcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployeeById(long id);

}