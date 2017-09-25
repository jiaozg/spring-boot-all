package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jiaozhiguang on 2017/7/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

    @Autowired
    private ObjectSender sender;

    @Test
    public void sendOject() throws Exception {
        User user=new User();
        user.setUserName("neo");
        user.setPassword("123456");
        sender.send(user);
    }

}
