package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryMethodTest {

	@Test
	public void test() {
		Meal fruit = Meal.valueOf("banana");
		Meal vegetable = Meal.valueOf("carrot");
		assertTrue("Banana should be a fruit but is "+fruit.getType(), fruit.getType().equals("fruit"));
		assertTrue("Carrot should be a vegetable but is "+vegetable.getType(), vegetable.getType().equals("vegetable"));
	}

}

class Meal {

	private String type;

	public Meal(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	// Example of factory method - different object is created depending on current context
	public static Meal valueOf(String ingredient) {
		if (ingredient.equals("banana")) {
			return new Meal("fruit");
		}
		return new Meal("vegetable");
	}

}
