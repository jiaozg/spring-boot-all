package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

}