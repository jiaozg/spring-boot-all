package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者.
 */
@Component
public class TopicConsumer {
    @JmsListener(destination = "sample.topic")
    public void receiveQueue(String text) {
        System.out.println("Consumer3="+text);
    }
}