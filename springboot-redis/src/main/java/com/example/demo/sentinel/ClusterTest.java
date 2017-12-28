package com.example.demo.sentinel;

import redis.clients.jedis.Jedis;

/**
 * Created by jiaozhiguang on 2017/11/24.
 */
public class ClusterTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6382);
        jedis.set("c", "c");
        System.out.println(jedis.get("c"));

        jedis = new Jedis("127.0.0.1", 6380);
        System.out.println(jedis.get("c"));

        jedis = new Jedis("127.0.0.1", 6381);
        System.out.println(jedis.get("c"));
    }


}
