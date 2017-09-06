package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisDistributedLockApplicationTests {

	@Autowired
	DistributedLockHandler distributedLockHandler;

	@Test
	public void testLock() {
		Lock lock = new Lock("lock", "sssssssss");

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					if(distributedLockHandler.tryLock(lock)){
						System.out.println(lock.getName());
						distributedLockHandler.releaseLock(lock);
					}
				}
			}).start();
		}
	}

	@Test
	public void testOne() {

		Lock lock = new Lock("lock", "sssssssss");
		if (distributedLockHandler.tryLock(lock)) {
			System.out.println(lock.getName());
			distributedLockHandler.releaseLock(lock);
		}

	}

}
