package com.neosoft.kafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "shubham", groupId = "myGroup")
    //myGroup is from properties file
    public void consume(String message) {
        log.info(String.format("message received  %s", message));
    }
}
