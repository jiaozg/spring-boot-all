package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> all = userMapper.getAll();
        return all;
    }

    @Override
    public UserEntity getOne(Long id) {
        return null;
    }

    @Override
    public void insert(UserEntity user) {

    }

    @Override
    public void update(UserEntity user) {

    }

    @Override
    public void delete(Long id) {

    }
}
