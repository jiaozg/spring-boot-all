package com.example.demo.limit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.ZParams;

import java.util.List;
import java.util.UUID;

public class RedisRateLimiterPlus {
    private static final String BUCKET = "BUCKET_";
    private static final String BUCKET_COUNT = "BUCKET_COUNT";
    private static final String BUCKET_MONITOR = "BUCKET_MONITOR_";

    public static String acquireTokenFromBucket(
            Jedis jedis, String point, int limit, long timeout) {
        String identifier = UUID.randomUUID().toString();
        long now = System.currentTimeMillis();
        Transaction transaction = jedis.multi();

        //删除信号量
        transaction.zremrangeByScore((BUCKET_MONITOR + point).getBytes(), "-inf".getBytes(), String.valueOf(now - timeout).getBytes());
        ZParams params = new ZParams();
        params.weightsByDouble(1.0, 0.0);
        transaction.zinterstore(BUCKET + point, params, BUCKET + point, BUCKET_MONITOR+point);

        //计数器自增
        transaction.incr(BUCKET_COUNT);
        List<Object> results = transaction.exec();
        long counter = (Long) results.get(results.size() - 1);

        transaction = jedis.multi();
        transaction.zadd(BUCKET_MONITOR + point, now, identifier);
        transaction.zadd(BUCKET + point, counter, identifier);
        transaction.zrank(BUCKET + point, identifier);
        results = transaction.exec();
        //获取排名，判断请求是否取得了信号量
        long rank = (Long) results.get(results.size() - 1);
        if (rank < limit) {
            return identifier;
        } else {//没有获取到信号量，清理之前放入redis 中垃圾数据
            transaction = jedis.multi();
            transaction.zrem(BUCKET_MONITOR + point, identifier);
            transaction.zrem(BUCKET + point, identifier);
            transaction.exec();
        }
        return null;
    }
}