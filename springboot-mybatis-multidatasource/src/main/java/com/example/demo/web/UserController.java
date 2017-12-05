package com.example.demo.web;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.test1.User1Mapper;
import com.example.demo.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

	@Autowired
	private User2Mapper user2Mapper;
	
	@RequestMapping("/getUser1s")
	public List<UserEntity> getUser1s() {
		List<UserEntity> users=user1Mapper.getAll();
		return users;
	}

    @RequestMapping("/getUser2s")
    public List<UserEntity> getUser2s() {
        List<UserEntity> users=user2Mapper.getAll();
        return users;
    }
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=user2Mapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
    
    
}