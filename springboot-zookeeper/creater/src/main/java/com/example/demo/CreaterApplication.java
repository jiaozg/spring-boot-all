package com.example.demo;

import com.example.demo.createor.CuratorCreateNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreaterApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CreaterApplication.class, args);
		CuratorCreateNode curatorCreateNode = new CuratorCreateNode("tomcat001");
	}
}

