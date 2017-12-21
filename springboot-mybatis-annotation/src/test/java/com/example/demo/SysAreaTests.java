package com.example.demo;

import com.example.demo.entity.SysAreaEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.enums.UserSexEnum;
import com.example.demo.mapper.SysAreaMapper;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysAreaTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private SysAreaMapper sysAreaMapper;

	@Test
	public void testUpdateName() throws Exception {
		sysAreaMapper.updateName(new SysAreaEntity("110000", "北京市1") );
	}
}
