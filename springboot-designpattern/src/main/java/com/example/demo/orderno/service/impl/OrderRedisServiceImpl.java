package com.example.demo.orderno.service.impl;

import com.example.demo.orderno.service.OrderService;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderRedisServiceImpl implements OrderService {

    static JedisPool jedisPool;

    static{
        jedisPool = new JedisPool(new JedisPoolConfig(),"127.0.0.1", 6379, 1000);
    }

    @Override
    public String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + jedisPool.getResource().incr("order_no");
    }
}
