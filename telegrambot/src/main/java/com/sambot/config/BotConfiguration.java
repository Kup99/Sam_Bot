package com.sambot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Data
@Configuration
@PropertySource("application.properties")
public class BotConfiguration {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String token;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
