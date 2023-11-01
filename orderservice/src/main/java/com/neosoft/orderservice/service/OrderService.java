package com.neosoft.orderservice.service;

import com.neosoft.orderservice.dto.OrderLineItemsDto;
import com.neosoft.orderservice.dto.OrderRequest;
import com.neosoft.orderservice.model.Order;
import com.neosoft.orderservice.model.OrderLineItems;
import com.neosoft.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

 /*   public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtosList()
                .stream()
                .map(orderLineItemsDto -> {
                    OrderLineItems orderLineItem = mapToDto(orderLineItemsDto);
                    // Manually assign an ID
                    orderLineItem.setId(Long.valueOf(2));
                    return orderLineItem;
                })
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }*/
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        // Initialize a counter with a starting value
//        AtomicLong idCounter = new AtomicLong(1);
//here we have stream data in orderLineItems and set to order object
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtosList()
                .stream()
                .map(orderLineItemsDto -> {
                    OrderLineItems orderLineItem = mapToDto(orderLineItemsDto);
                    // Manually assign an incremented ID
                  //  orderLineItem.setId(idCounter.getAndIncrement());
                    orderLineItem.setId(Long.valueOf(2));
                    // Increment the counter for the next item
                    return orderLineItem;
                })
                .toList();
        order.setOrderLineItemsList(orderLineItems);
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
