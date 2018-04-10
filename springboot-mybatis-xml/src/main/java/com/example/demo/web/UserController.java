package com.example.demo.web;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


}