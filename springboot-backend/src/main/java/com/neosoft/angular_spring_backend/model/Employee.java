package com.neosoft.angular_spring_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "birthdate")
    @JsonFormat(pattern = "MM-dd-yyyy", timezone = "UTC")
    private LocalDate birthdate;

    public Employee(String firstName, String lastName, String emailId, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.birthdate = birthdate;
    }
    //epoc-date
}
