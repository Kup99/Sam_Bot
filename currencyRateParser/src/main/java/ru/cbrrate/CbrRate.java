package ru.cbrrate;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CbrRate {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(CbrRate.class).run(args);
    }
}
