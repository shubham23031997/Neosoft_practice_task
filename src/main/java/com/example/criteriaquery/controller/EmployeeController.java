package com.example.criteriaquery.controller;

import com.example.criteriaquery.entity.Employee;
import com.example.criteriaquery.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @GetMapping("/findAllEmpByCriteriaQuery")
    public List<Employee> findAllEmployeeByCriteriaQuery() {
        return employeeService.findAllEmployeeByCriteriaQuery();
    }

    @GetMapping("/findAllEmpGreaterSalary")
    public List<Employee> getEmpSalaryIsGreaterThan5000() {
        return employeeService.getEmpSalaryIsGreaterThan5000();
    }

    @GetMapping("/findAllEmpNameStartsWith")
    public List<Employee> findEmployeeNameStartsWith() {
        return employeeService.findEmployeeNameStartsWith();
    }

    @GetMapping("/findAllEmpLessSalary")
    public List<Employee> getEmpSalaryIsLessThan20000() {
        return employeeService.getEmpSalaryLessThan20000();
    }

    @GetMapping("/findAllEmpGreaterThanOrEqual")
    public List<Employee> getAllEmpGreaterThanOrEqualList() {
        return employeeService.getEmpSalaryGreaterThanOrEqual8000();
    }
}
