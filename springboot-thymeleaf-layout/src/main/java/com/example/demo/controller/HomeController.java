package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by jiaozhiguang on 2017/8/24.
 */
@Controller
class HomeController {

    @GetMapping("/")
    String root(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }


    @GetMapping("/index")
    String index() {
        return "index";
    }

}
