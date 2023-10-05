package com.neosoft.kafka.controller;

import com.neosoft.kafka.kafka.KafkaConsumer;
import com.neosoft.kafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    private KafkaConsumer kafkaConsumer;

    //  @Autowired if spring bean having only one constructor then we can avoid using Autowired annotation from
    //  spring2.1 onwards we can ignore this annotation if spring bean contain only one parameterized constructor
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //  http://localhost:8080/api/v1/kafka/publish/?message=hello%20word
    //THis is Producer api
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to the topic");
    }

//    @PostMapping("/publish")
//    public ResponseEntity<String> publish(@RequestParam("message") String message) {
//        kafkaConsumer.sendMessage(message);
//        return ResponseEntity.ok("message sent to the topic");
//    }
}
