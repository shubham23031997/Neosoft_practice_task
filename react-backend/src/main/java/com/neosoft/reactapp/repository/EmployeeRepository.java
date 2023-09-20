package com.neosoft.reactapp.repository;

import com.neosoft.reactapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom queries here if needed
}
