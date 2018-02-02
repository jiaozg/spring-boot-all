package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSwaggerApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testGetBooks() {
		ResponseEntity<String> responseEntity =  restTemplate.getForEntity("http://localhost:8081/books", String.class);
		System.out.println(responseEntity);
	}



}
