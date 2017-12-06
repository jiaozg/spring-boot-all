package com.example.demo;

import com.example.demo.wathcer.CuratorWatcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WatcherApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(WatcherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//your logic
		System.out.println("into zjk run");
		new CuratorWatcher().monitor();
	}

}
