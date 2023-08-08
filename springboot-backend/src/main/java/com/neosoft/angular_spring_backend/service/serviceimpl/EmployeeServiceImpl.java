package com.neosoft.angular_spring_backend.service.serviceimpl;

import com.neosoft.angular_spring_backend.model.Employee;
import com.neosoft.angular_spring_backend.repository.EmployeeRepository;
import com.neosoft.angular_spring_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        Optional<Employee> Employee = employeeRepo.findById(id);
        return Employee;
    }

    @Override
    public Employee createEmployee(Employee Employee) {

        return employeeRepo.save(Employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee Employee) {
        Employee updateEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("user not exist with id" + id));
        updateEmployee.setId(Employee.getId());
        updateEmployee.setFirstName(Employee.getFirstName());
        updateEmployee.setLastName(Employee.getLastName());
        updateEmployee.setEmailId(Employee.getEmailId());
        //updateEmployee.setBirthdate(Employee.getBirthdate());
        employeeRepo.save(updateEmployee);
        return Employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
