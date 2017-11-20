package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Controller
@SpringBootApplication
@EnableWebSocket
public class Application {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	@Bean
    public OnlineServer onlienServerEndpoint() {
        return new OnlineServer();
    }

    @Bean
    public ChatRoom chatRoomEndpoint() {
        return new ChatRoom();
    }
}