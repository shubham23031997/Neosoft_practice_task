package com.neosoft.orderservice.controller;

import com.neosoft.orderservice.dto.OrderRequest;
import com.neosoft.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Created Successfully";
    }

    public String fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return "Oops! something went wrong, please order after some time!";
    }
}
