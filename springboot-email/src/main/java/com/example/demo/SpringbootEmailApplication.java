package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmailApplication.class, args);
	}
}
