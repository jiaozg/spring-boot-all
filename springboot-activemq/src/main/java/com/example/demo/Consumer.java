package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 消息消费者.
 */
@Component
public class Consumer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @JmsListener(destination = "quartzTopic")
    public void receiveQueue(String text) {
        System.out.println("quartzTopic="+text);



        //send queue.
        this.jmsMessagingTemplate.convertAndSend(this.queue, "test,success");
    }
}