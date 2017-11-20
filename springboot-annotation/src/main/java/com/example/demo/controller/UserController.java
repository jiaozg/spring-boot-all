package com.example.demo.controller;

import com.example.demo.actionlog.ActionLog;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiaozhiguang on 2017/9/20.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ActionLog(action = "测试方法")
    public String test(@PathVariable Long id){
        return "Hello World" + id;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

}



