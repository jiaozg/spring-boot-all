package com.example.demo.service;

import com.example.demo.domain.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;
  
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");  
        return userInfoRepository.findByUsername(username);  
    }  
  
}  