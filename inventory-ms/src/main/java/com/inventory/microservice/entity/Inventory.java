package com.inventory.microservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private int quantity;

    @Column
    private String item;
}
