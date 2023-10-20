package com.inventory.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentEvent {

    private String type;

    private CustomerOrder order;

}
