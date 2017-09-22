package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompositeTest {

	@Test
	public void test() {
		TextTagComposite composite = new PTag();
		composite.addTag(new SpanTag());
		composite.addTag(new EmTag());

		// sample client code
		composite.startWrite();
		for (TextTag leaf : composite.getTags()) {
			leaf.startWrite();
			leaf.endWrite();
		}
		composite.endWrite();
		assertTrue("Composite should contain 2 tags but it contains "+composite.getTags().size(), composite.getTags().size() == 2);
	}

}


interface TextTag {
	public void startWrite();
	public void endWrite();
}

interface TextTagComposite extends TextTag {
	public List<TextTag> getTags();
	public void addTag(TextTag tag);
}

class PTag implements TextTagComposite {
	private List<TextTag> tags = new ArrayList<TextTag>();

	@Override
	public void startWrite() {
		System.out.println("<p>");
	}

	@Override
	public void endWrite() {
		System.out.println("</p>");
	}

	@Override
	public List<TextTag> getTags() {
		return tags;
	}

	@Override
	public void addTag(TextTag tag) {
		tags.add(tag);
	}
}

class SpanTag implements TextTag {

	@Override
	public void startWrite() {
		System.out.println("<span>");
	}

	@Override
	public void endWrite() {
		System.out.println("</span>");
	}

}

class EmTag implements TextTag {

	@Override
	public void startWrite() {
		System.out.println("<em>");
	}

	@Override
	public void endWrite() {
		System.out.println("</em>");
	}

}
