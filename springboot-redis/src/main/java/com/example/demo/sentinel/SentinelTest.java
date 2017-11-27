package com.example.demo.sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiaozhiguang on 2017/11/25.
 */
public class SentinelTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Set<String> sentinels = new HashSet<>();
        sentinels.add("127.0.0.1:26380");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = jedisSentinelPool.getResource();
        jedis.set("time", sdf.format(new Date()));

        System.out.println(jedis.get("time"));
    }

}
