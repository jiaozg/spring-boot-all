package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;


@SpringBootApplication
@EnableScheduling
@EnableJms
public class SpringbootFirstApplication {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	@Bean
	public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory,
															   DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// the configurer will use PubSubDomain from application.properties if defined or false if not
		//so setting it on the factory level need to be set after this
		configurer.configure(factory, connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstApplication.class, args);
	}
}
