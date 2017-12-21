package com.example.demo.controller;

import com.example.demo.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by jiaozhiguang on 2017/9/22.
 */
@RestController
public class HelloController {

    @Autowired
    RedisRepository redisRepository;

    @GetMapping("/")
    public String hello() {

        String test = redisRepository.getValue("client");
        System.out.println(test);
        redisRepository.setKey("client", "client");
        test = redisRepository.getValue("client");
        System.out.println(test);

        return  "Hello World "+ 9081;
    }

    //keys '*sessions*'
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
