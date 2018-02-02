package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiaozhiguang on 2018/1/7.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


}
