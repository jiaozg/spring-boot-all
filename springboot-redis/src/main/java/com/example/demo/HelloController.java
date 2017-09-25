package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/9/22.
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(String port) {
        return  "hello  123 " + port;
    }
}
