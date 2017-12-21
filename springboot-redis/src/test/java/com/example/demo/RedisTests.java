package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.RedisRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

	public static Logger logger= LoggerFactory.getLogger(RedisTests.class);
	@Test
	public void contextLoads() {
	}

	@Autowired
	RedisRepository repository;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedis(){
		repository.setKey("name","forezp");
		repository.setKey("age","11");
		logger.info(repository.getValue("name"));
		logger.info(repository.getValue("age"));
	}

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		stringRedisTemplate.opsForValue().set("bbb", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testObj() throws Exception {
		User user=new User(1L, "aa@126.com", "aa");
		ValueOperations<String, User> operations=redisTemplate.opsForValue();
		operations.set("user", user);
		operations.set("com.neox", user);
		operations.set("com.neo.f", user,1, TimeUnit.SECONDS);
//		Thread.sleep(1000);
		//redisTemplate.delete("com.neo.f");
		boolean exists=redisTemplate.hasKey("com.neo.f");
		if(exists){
			System.out.println("exists is true");
		}else{
			System.out.println("exists is false");
		}
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}

}
