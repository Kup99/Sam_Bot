package com.sambot.controller;

import com.sambot.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

//    private final KafkaProducer kafkaProducer;
//
//    public KafkaController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

//    @PostMapping("/kafka/send")
//    public String sendMessage(@RequestBody String message) {
//        kafkaProducer.sendMessage(message);
//        return "success";
//    }


}
