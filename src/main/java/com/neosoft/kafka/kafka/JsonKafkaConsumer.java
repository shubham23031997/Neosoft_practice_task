package com.neosoft.kafka.kafka;

import com.neosoft.kafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {
    @KafkaListener(topics = "shubham_json")
    public void consume(User user){

    }
}
