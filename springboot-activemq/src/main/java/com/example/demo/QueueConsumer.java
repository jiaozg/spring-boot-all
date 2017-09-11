package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者.
 */
@Component
public class QueueConsumer {
    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println("queue="+text);
    }
}
