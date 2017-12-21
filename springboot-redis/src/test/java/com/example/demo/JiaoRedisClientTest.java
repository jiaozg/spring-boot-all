package com.example.demo;

import com.example.demo.handwrite.JiaoReidsClient;
import org.junit.Test;

/**
 * Created by jiaozhiguang on 2017/12/20.
 */
public class JiaoRedisClientTest {

    @Test
    public void clientTest() throws Exception {
        JiaoReidsClient client = new JiaoReidsClient();

        client.set("jiao", "hello");

        System.out.println(client.get("jiao"));

    }
}
