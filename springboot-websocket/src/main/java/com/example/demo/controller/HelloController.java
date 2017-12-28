package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/12/26.
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello" + 9081;
    }

}
