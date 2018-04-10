package com.example.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**

 Start Name Server
 > nohup sh bin/mqnamesrv &
 > tail -f ~/logs/rocketmqlogs/namesrv.log
 The Name Server boot success...
 Start Broker
 > nohup sh bin/mqbroker -n localhost:9876 &
 > tail -f ~/logs/rocketmqlogs/broker.log
 The broker[%s, 172.30.30.233:10911] boot success...

 /bin/mqbroker -m 查看rocketmq参数

 */

public class BroadcastProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setNamesrvAddr("localhost"); //No name server address, please set it.
        producer.start();

        for (int i = 0; i < 100; i++){
            Message msg = new Message("TopicTest",
                "TagA",
                "OrderID188",
                "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }
}