package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by jiaozhiguang on 2018/1/8.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() throws Exception {
        new TestThread().start();
        return "Hello";
    }

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return "Hello" + name;
    }

    @GetMapping("/sayHello2")
    public String sayHello2(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.append(entry.getKey()).append(":").append(entry.getValue());
        }
        return "Hello : " + builder;
    }

    class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println(sayHello("thread test"));
        }
    }

}
