package com.example.demo;

import com.example.demo.rabbit.many.NeoSender;
import com.example.demo.rabbit.many.NeoSender2;
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
public class ManyTest {
    @Autowired
    private NeoSender neoSender;

    @Autowired
    private NeoSender2 neoSender2;

    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<10;i++){
            neoSender.send(i);
        }
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i=0;i<10;i++){
            neoSender.send(i);
            neoSender2.send(i);
        }
    }

}
