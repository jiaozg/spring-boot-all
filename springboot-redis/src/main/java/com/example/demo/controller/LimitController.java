package com.example.demo.controller;

import com.example.demo.limit.RateLimiter;
import com.example.demo.limit.RedisRateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiaozhiguang on 2017/9/22.
 */
@RestController
public class LimitController {

    @GetMapping("/limit")
    public String index(HttpServletResponse response) throws IOException {
        Jedis jedis =  RedisRateLimiter.pool.getResource();
        String token = RedisRateLimiter.acquireTokenFromBucket(jedis, 2, 5000);
        if (token == null) {
//            response.sendError(500);
            return "limited";
        }else{
            return "do business";
        }
    }


    @RateLimiter(limit = 2, timeout = 5000)
    @GetMapping("/limittest")
    public void test() {
    }
}
