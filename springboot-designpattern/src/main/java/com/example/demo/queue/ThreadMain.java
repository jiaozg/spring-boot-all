package com.example.demo.queue;

import java.util.concurrent.DelayQueue;

public class ThreadMain {

	public static void main(String[] args) throws Exception {
        final DelayQueue<Student> bq = new DelayQueue<Student>();
		for (int i = 0; i < 5; i++) {
			Student student = new Student("学生" + i, Math.round((Math.random()*1000 + i)));
			bq.put(student);
		}
		while (true) {
			if (bq.isEmpty()) {
				break;
			} else {
				Student student = bq.poll();
				if (student != null) {
					System.out.println("bq.peek();" + student.getName());
				}
				Thread.sleep(1000);

			}
		}

	}
}