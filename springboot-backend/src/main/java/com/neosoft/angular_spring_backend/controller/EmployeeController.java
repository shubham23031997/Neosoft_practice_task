package com.neosoft.angular_spring_backend.controller;

import com.neosoft.angular_spring_backend.exception.ResourceNotFoundException;
import com.neosoft.angular_spring_backend.model.Employee;
import com.neosoft.angular_spring_backend.model.requests.EmployeeRequestDto;
import com.neosoft.angular_spring_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    //private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequestDto employee) {
        return employeeService.createEmployee(employee);
    }

    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setBirthdate(employeeDetails.getBirthdate());
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(employee.getFirstName(), employee.getLastName(), employee.getEmailId(), String.valueOf(employee.getBirthdate()));
        Employee updatedEmployee = employeeService.createEmployee(employeeRequestDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
