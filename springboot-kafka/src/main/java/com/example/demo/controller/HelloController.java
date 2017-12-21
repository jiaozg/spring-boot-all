package com.example.demo.controller;

import com.example.demo.MyConsumer;
import com.example.demo.MyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/12/6.
 */
@RestController
public class HelloController {

    @Autowired
    private MyConsumer consumerTest;

    @Autowired
    private MyProducer producerTest;

    @GetMapping("/")
    public String hello() {

        consumerTest.consume();

        return "hello";
    }

    @GetMapping("/consum")
    public String consum() {
        consumerTest.consume();
        return "consum";
    }

    @GetMapping("/produce")
    public String produce() {
        producerTest.produce();
        return "produce";
    }

}
