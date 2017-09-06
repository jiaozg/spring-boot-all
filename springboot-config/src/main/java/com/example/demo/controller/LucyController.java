package com.example.demo.controller;

import com.example.demo.bean.ConfigBean;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/8/21.
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class LucyController {

    @Autowired
    ConfigBean configBean;

    @Autowired
    User user;

    @RequestMapping(value = "/lucy")
    public String miya(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @RequestMapping(value = "/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}
