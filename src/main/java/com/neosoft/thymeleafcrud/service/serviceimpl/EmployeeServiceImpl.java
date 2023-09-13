package com.neosoft.thymeleafcrud.service.serviceimpl;


import com.neosoft.thymeleafcrud.model.Employee;
import com.neosoft.thymeleafcrud.repository.EmployeeRepository;
import com.neosoft.thymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
