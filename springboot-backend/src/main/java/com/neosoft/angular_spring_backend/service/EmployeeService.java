package com.neosoft.angular_spring_backend.service;

import com.neosoft.angular_spring_backend.model.Employee;
import com.neosoft.angular_spring_backend.model.requests.EmployeeRequestDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Optional<Employee> findEmployeeById(Long id);

    Employee createEmployee(EmployeeRequestDto employeeRequestDto);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

}
