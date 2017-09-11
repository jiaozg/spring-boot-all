package com.example.demo;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 消息生产者.
 */
@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

//    @Scheduled(fixedDelay=30000)//每3s执行1次
    public void send() {
        //send queue.
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
        //send topic.
        this.jmsMessagingTemplate.convertAndSend(this.topic, "hi,activeMQ(topic)");
    }

}
