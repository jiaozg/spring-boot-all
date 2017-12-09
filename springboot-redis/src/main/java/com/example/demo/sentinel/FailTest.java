package com.example.demo.sentinel;

import redis.clients.jedis.Jedis;

/**
 * Created by jiaozhiguang on 2017/12/8.
 */
public class FailTest {

    public static Jedis jedis = null;

    public static void main(String[] args) {

            for (int i = 0; i < 5; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                Jedis jedis = new Jedis("127.0.0.1", 6379);
                                jedis.set("d", "d");
                                System.out.println(jedis.get("d") + Thread.currentThread().getName());
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                jedis = new Jedis("127.0.0.1", 6379);
                                System.err.println("连接断开了" + Thread.currentThread().getName());
                            }
                        }

                    }
                }).start();
            }


    }

}
