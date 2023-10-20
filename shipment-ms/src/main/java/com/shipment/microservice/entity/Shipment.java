package com.shipment.microservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Shipment {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String address;


    @Column
    private String status;


    @Column
    private long orderId;


}
