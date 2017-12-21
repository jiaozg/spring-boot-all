package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonTest {

	@Test
	public void test() {
		President president1 = (President) SingletonsHolder.PRESIDENT.getHoldedObject();
		President president2 = (President) SingletonsHolder.PRESIDENT.getHoldedObject();
		assertTrue("Both references of President should point to the same object", president1 == president2);
		System.out.println("president1 = "+president1+" and president2 = "+president2);
		// sample output
		// president1 = com.waitingforcode.client.President@17414c8 and president2 = com.waitingforcode.client.President@17414c8

	}

}

enum SingletonsHolder {

	PRESIDENT(new President());

	private Object holdedObject;

	private SingletonsHolder(Object o) {
		this.holdedObject = o;
	}

	public Object getHoldedObject() {
		return this.holdedObject;
	}

}

class President {
}
