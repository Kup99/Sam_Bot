package com.sambot.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic messageTopic(){
        return new NewTopic("message-topic",1, (short) 1);
    }

}
