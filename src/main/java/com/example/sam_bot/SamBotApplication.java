package com.example.sam_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.example.sam_bot.*")
@SpringBootApplication
@EnableJpaRepositories("com.example.sam_bot.repository")
@EntityScan("com.example.sam_bot.model")

public class SamBotApplication {

    public SamBotApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SamBotApplication.class, args);
    }

}
