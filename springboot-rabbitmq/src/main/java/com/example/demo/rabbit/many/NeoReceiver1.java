package com.example.demo.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiaozhiguang on 2017/7/26.
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver1 {

    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver 1: " + neo);
    }

}
