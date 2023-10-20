package com.shipment.microservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerOrder {

    private String item;

    private int quantity;

    private double amount;

    private String paymentMode;

    private Long orderId;

    private String address;

}
