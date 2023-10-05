package com.neosoft.kafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {
    // private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("message sent %s ", message));
        kafkaTemplate.send("shubham", message);
    }
    //here we need to start 1. zookeper run
    //.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

    //2.kafka sever
    //.\bin\windows\kafka-server-start.bat .\config\server.properties

    //send message through browser
    //http://localhost:8080/api/v1/kafka/publish/?message=hello world
    //check message get on consumer same name as above
    //.\bin\windows\kafka-console-consumer.bat --topic myTopic --from-beginning --bootstrap-server localhost:9092
}
