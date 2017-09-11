package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
public class SpringbootActivemqApplication {

	@Bean
	public Queue queue() {
//		return new ActiveMQQueue("sample.queue");
		return new ActiveMQQueue("taskReturnQueue");
	}

	@Bean
	public Topic topic() {
		return new ActiveMQTopic("sample.topic");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActivemqApplication.class, args);
	}
}
