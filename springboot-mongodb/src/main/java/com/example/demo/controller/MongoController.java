package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiaozhiguang on 2017/11/9.
 */
@RestController
public class MongoController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/mongo")
    public List<Customer> mongo() {
        return  customerRepository.findByLastName("Smith");
    }

}
