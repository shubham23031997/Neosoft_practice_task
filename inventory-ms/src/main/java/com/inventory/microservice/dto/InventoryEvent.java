package com.inventory.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryEvent {

    private String type;

    private CustomerOrder order;

}
