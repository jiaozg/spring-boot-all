package com.example.demo;

import com.example.demo.repository.RedisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	public static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);
	@Test
	public void contextLoads() {
	}

	@Autowired
	RedisRepository repository;
	@Test
	public void testRedis(){
		repository.setKey("name","forezp");
		repository.setKey("age","11");
		logger.info(repository.getValue("name"));
		logger.info(repository.getValue("age"));
	}

}
