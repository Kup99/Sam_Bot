//package com.sambot.kafka;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaProducer {
//
//    public final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    public void sendMessage(String message){
//        kafkaTemplate.send("message-topic",message);
//    }
//}
