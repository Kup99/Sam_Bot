package com.example.sam_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages={"com.example.sam_bot.MessageService"})
@SpringBootApplication
public class SamBotApplication {

    public SamBotApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SamBotApplication.class, args);
    }
}
