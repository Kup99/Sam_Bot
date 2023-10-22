package com.example.sam_bot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan
//@EnableJpaRepositories("com.example.sam_bot.repository")
public class SamBotApplication {

    public SamBotApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SamBotApplication.class, args);
    }
}
