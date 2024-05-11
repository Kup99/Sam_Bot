package com.sambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sambot.*")
public class SpringMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
	}

}
