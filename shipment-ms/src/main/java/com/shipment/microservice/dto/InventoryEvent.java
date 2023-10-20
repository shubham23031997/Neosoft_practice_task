package com.shipment.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventoryEvent {

    private String type;

    private CustomerOrder order;

}
