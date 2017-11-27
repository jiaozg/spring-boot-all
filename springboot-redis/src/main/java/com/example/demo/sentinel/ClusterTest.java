package com.example.demo.sentinel;

import redis.clients.jedis.Jedis;

/**
 * Created by jiaozhiguang on 2017/11/24.
 */
public class ClusterTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6380);
        jedis.set("hello", "world");
        System.out.println(jedis.get("hello"));

        jedis = new Jedis("127.0.0.1", 6381);
        System.out.println(jedis.get("hello"));

        jedis = new Jedis("127.0.0.1", 6382);
        System.out.println(jedis.get("hello"));
    }


}
