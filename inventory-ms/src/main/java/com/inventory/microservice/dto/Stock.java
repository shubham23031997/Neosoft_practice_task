package com.inventory.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock {

    private String item;

    private int quantity;
}
