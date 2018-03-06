package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created by jiaozhiguang on 2018/2/10.
 */
@Controller
public class FileController {

    @Value("${test.msg}")
    private String msg;

    @Autowired
    private Environment env;



    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/hello")
    public String hello(Model model){

        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("world", messageSource.getMessage("world", null, locale));
        return"/hello";

    }

    //使用@Value方式（常用）
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "The Way 1 : " +msg;
    }

    //使用Environment方式
    @RequestMapping(value = "index2", method = RequestMethod.GET)
    public String index2() {

        return "The Way 2 : " + env.getProperty("test.msg");
    }



}
