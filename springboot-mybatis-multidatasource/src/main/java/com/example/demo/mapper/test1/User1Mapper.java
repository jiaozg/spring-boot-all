package com.example.demo.mapper.test1;


import com.example.demo.entity.UserEntity;

import java.util.List;

public interface User1Mapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}