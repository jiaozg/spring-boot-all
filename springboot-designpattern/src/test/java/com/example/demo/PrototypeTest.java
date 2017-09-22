package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrototypeTest {

	@Test
	public void test() throws CloneNotSupportedException {
		Robot firstRobot = new Robot("Droid#1");
		Robot secondRobot = (Robot) firstRobot.clone();
		assertTrue("Cloned robot's instance can't be the same as the"
						+" source robot instance",
				firstRobot != secondRobot);
		assertTrue("Cloned robot's name should be '"+firstRobot.getName()+"'"
						+" but was '"+secondRobot.getName()+"'",
				secondRobot.getName().equals(firstRobot.getName()));
	}

}


class Robot implements Cloneable {
	private String name;

	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
