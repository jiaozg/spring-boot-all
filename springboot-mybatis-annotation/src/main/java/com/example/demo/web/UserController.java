package com.example.demo.web;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

    @RequestMapping("/getTwoTable")
    public List<UserEntity> getTwoTable() {
        List<UserEntity> users=userMapper.getTwoTable();
        return users;
    }

    @RequestMapping("/getPageUsers")
    public PageInfo<UserEntity> getPageUsers(@RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> users=userMapper.getAll();
        PageInfo<UserEntity> pageInfo = new PageInfo<UserEntity>(users);
        return pageInfo;
    }
	
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
    
    
}