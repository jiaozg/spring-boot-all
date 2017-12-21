package com.example.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by jiaozhiguang on 2017/12/20.
 */
public class JiaoRedisProxyTest {

    @Test
    public void clientTest() throws Exception {
        String proxyHost = "127.0.0.1";
        int proxyPort = 19000;

        Jedis jedis = null;
        String response = null;

        jedis = new Jedis(proxyHost, proxyPort);
        response = jedis.set("a", "a");
        jedis.close();
        System.out.println("返回结果："+response);

        jedis = new Jedis(proxyHost, proxyPort);
        response = jedis.set("ab", "ab");
        jedis.close();
        System.out.println("返回结果："+response);

        jedis = new Jedis(proxyHost, proxyPort);
        response = jedis.set("abc", "abc");
        jedis.close();
        System.out.println("返回结果："+response);

        jedis = new Jedis(proxyHost, proxyPort);
        response = jedis.set("abcd", "abcd");
        jedis.close();
        System.out.println("返回结果："+response);

    }
}
