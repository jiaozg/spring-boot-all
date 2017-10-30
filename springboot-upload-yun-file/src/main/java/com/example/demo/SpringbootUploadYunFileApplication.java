package com.example.demo;

import com.example.demo.servlet.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringbootUploadYunFileApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootUploadYunFileApplication.class, args);
	}
}
