package com.example.demo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiaozhiguang on 2017/9/11.
 */
@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println("from consumer : "+ text);
    }

}
