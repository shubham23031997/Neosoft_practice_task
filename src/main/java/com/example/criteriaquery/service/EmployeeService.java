package com.example.criteriaquery.service;

import com.example.criteriaquery.dao.EmployeeDao;
import com.example.criteriaquery.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Transactional
    public List<Employee> findAllEmployeeByCriteriaQuery() {
        return employeeDao.findAllEmployeeByCriteriaQuery();
    }

    @Transactional
    public List<Employee> getEmpSalaryIsGreaterThan5000() {
        return employeeDao.getEmpSalaryIsGreaterThan5000();
    }

    @Transactional
    public List<Employee> findEmployeeNameStartsWith() {
        return employeeDao.findEmployeeNameStartsWith();
    }

    public List<Employee> getEmpSalaryLessThan20000() {
        return employeeDao.getEmpSalaryLessThan20000();
    }

    public List<Employee> getEmpSalaryGreaterThanOrEqual8000() {
        return employeeDao.getEmpSalaryGreaterThanOrEqual8000();
    }
}
