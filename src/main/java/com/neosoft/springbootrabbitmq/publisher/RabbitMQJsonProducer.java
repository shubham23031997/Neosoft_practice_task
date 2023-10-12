package com.neosoft.springbootrabbitmq.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.jsonQueue.name}")
    private String jsonQueue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.jsonExchange.name}")
    private String jsonExchange;

    @Value("${rabbitmq.jsonRoutingKey.name}")
    private String jsonRoutingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendJsonMessage(){
        log.info(String.format("message "));
    }
}
