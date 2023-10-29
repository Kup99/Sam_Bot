package com.example.sam_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

//@ComponentScan(basePackages={"com.example.sam_bot.MessageService"})
@SpringBootApplication
@EnableJpaRepositories
public class SamBotApplication {

    public SamBotApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SamBotApplication.class, args);
    }

}
