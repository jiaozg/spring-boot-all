package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
@RestController
public class HelloController {

    @PostMapping("/")
    public String testPost(String name) {
        return name;
    }

    @GetMapping("/testget")
    public String getGet(String name) {
        return name;
    }
}
