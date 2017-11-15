package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/9/25.
 */
@RestController
public class DubboController {

    @Autowired
    CityDubboConsumerService service;

    @GetMapping("/")
    public City getCity() {
        return service.printCity();
    }

}
