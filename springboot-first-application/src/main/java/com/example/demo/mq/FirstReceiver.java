package com.example.demo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FirstReceiver {

    @JmsListener(destination = "quartzTopic")
    public void receiveMessage(String str) {
        System.out.println("FirstReceiver <" + str + ">");
    }

}
