package com.neosoft.angular_spring_backend.service.serviceimpl;

import com.neosoft.angular_spring_backend.model.Employee;
import com.neosoft.angular_spring_backend.model.requests.EmployeeRequestDto;
import com.neosoft.angular_spring_backend.repository.EmployeeRepository;
import com.neosoft.angular_spring_backend.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee;
    }

    @Override
    public Employee createEmployee(EmployeeRequestDto employeeRequestDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(employeeRequestDto.getBirthdate(), formatter);
        Employee employee = new Employee(employeeRequestDto.getFirstName(), employeeRequestDto.getLastName(), employeeRequestDto.getEmailId(), date);
        log.info("employees details :: {}", employee);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee updateEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("user not exist with id" + id));
        updateEmployee.setId(employee.getId());
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmailId(employee.getEmailId());
        updateEmployee.setBirthdate(employee.getBirthdate());
        employeeRepo.save(updateEmployee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
