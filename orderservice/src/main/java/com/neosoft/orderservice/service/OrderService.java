package com.neosoft.orderservice.service;

import com.neosoft.orderservice.dto.OrderLineItemsDto;
import com.neosoft.orderservice.dto.OrderRequest;
import com.neosoft.orderservice.model.Order;
import com.neosoft.orderservice.model.OrderLineItems;
import com.neosoft.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
//so spring automatically create and commit transaction
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        //here we have stream data in orderLineItems and set to order object
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtosList()
                .stream()
                //.map(this::mapToDto)
                .map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        //call inventory service for placing creating order if product is in stock
        Boolean result = webClient
                .get().uri("http://localhost:8082/api/inventory")
                .retrieve()
                .bodyToMono(Boolean.class).block();
        //now web client make synchronous request
        if (result) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("product is not in stock, please try again later");
        }
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
  /*  public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        // Initialize a counter with a starting value
        final Long[] idCounter = {1L};
//        AtomicLong idCounter = new AtomicLong(1);
//here we have stream data in orderLineItems and set to order object
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtosList()
                .stream()
                .map(orderLineItemsDto -> {
                    OrderLineItems orderLineItem = mapToDto(orderLineItemsDto);
                    // Manually assign an incremented ID
//                    orderLineItem.setId(idCounter.getAndIncrement());
                    orderLineItem.setId(idCounter[0]);
                    idCounter[0]++;
                    //orderLineItem.setId(Long.valueOf(2));
                    // Increment the counter for the next item
                    return orderLineItem;
                })
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }*/