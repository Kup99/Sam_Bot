package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "message-topic", groupId = "message_consumer")
    public void listen(String message) {
        System.out.println("Kafka get message " + message);
    }

}
