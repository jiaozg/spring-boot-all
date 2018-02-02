package com.example.demo.web;

import com.example.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiaozhiguang on 2017/12/22.
 */
@Controller
public class HomeController {

    @Autowired
    MenuMapper menuMapper;

    @GetMapping("/")
    public String toindex(Model model) {
        model.addAttribute("menulist", menuMapper.selectAll());
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}

