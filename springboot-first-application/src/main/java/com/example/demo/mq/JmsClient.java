package com.example.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;



/**
 * 消息生产者,用于发送消息
 * @author Mac
 *
 */
@Service("jmsClient")
public class JmsClient  {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendMessage(Destination destination, final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
    }



}
