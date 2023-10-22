package com.example.sam_bot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class SamBotApplication {

    public SamBotApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SamBotApplication.class, args);
    }
}
