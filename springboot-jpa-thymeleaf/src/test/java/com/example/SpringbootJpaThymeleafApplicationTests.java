package com.example;

import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaThymeleafApplicationTests {

	@Resource
	UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testList() {
		System.out.println(userService.getUserList());
	}

}
