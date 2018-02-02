package com.example.demo.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.math.BigDecimal;
import java.util.Set;

/**
 * 订单超时过期处理
 * 数据库定时任务
 * 延迟队列
 *
 *
 * zadd hackers 1940 "Alan Kay"
 * zadd hackers 1912 "Alan Turing"
 *
 * zrange hackers 0 -1 查询所有
 *
 * zrevrange hackers 0 -1 倒叙
 *
 * zrange hackers 0 -1 withscores
 *
 */
public class DelayOrder {

    static JedisPool pool = new JedisPool();
    static Jedis jedis = pool.getResource();

    public static void main(String[] args) throws Exception {

        producer();
        consumer();

//        getAll();
    }

    public static void producer() {
        for (int i = 0; i < 20; i++) {
            jedis.zadd("orderno", System.currentTimeMillis(), "Order100" + String.format("%02d", i));
        }
    }

    public static void getAll() {
        Set<Tuple> set = jedis.zrangeWithScores("orderno", 0, 0);
        for (Tuple tuple : set) {
//            System.out.println(tuple.getElement());
//            System.out.println(tuple.getScore());
            BigDecimal score = new BigDecimal(tuple.getScore());
            System.out.println(score.toPlainString());
        }
    }

    public static Tuple getOldest() {
        Set<Tuple> set = jedis.zrangeWithScores("orderno", 0, 0);
        for (Tuple tuple : set) {
            return tuple;
        }
        return null;
    }


    public static void consumer() throws Exception {
        while (true) {
            Tuple tuple = getOldest();
            if (tuple != null) {
                String orderId = tuple.getElement();
                long score = getScore(tuple);

                if (System.currentTimeMillis() - score > 5000 ) {
                    jedis.zrem("orderno", orderId);
                    System.out.println("orderId : " + orderId + " time out ");
                }
            } else {
                Thread.sleep(500);
            }


        }
    }


    public static long getScore(Tuple tuple) {
        BigDecimal score = new BigDecimal(tuple.getScore());
        return Long.valueOf(score.toPlainString()).longValue();
    }

}
