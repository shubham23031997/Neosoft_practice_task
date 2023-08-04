package com.neosoft.multithreading_executor_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String personName;

}

