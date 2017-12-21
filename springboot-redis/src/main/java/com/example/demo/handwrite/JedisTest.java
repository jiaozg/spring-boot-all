package com.example.demo.handwrite;

import redis.clients.jedis.Jedis;

/**
 * Created by jiaozhiguang on 2017/11/24.
 */
public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6378);
        jedis.set("tony", "hello");
        System.out.println(jedis.get("tony"));
        jedis.close();

    }


}
