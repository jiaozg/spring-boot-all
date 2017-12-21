package com.example.demo.handwrite;

import redis.clients.jedis.Jedis;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/**
 * Created by jiaozhiguang on 2017/12/21.
 */
public class JiaoRedisSentinel {

    static String master;

    static final Vector<String> slaves = new Vector<>();
    static final Vector<String> downServers = new Vector<>();

    public static void main(String[] args) throws Exception{
        config("127.0.0.1:6380");

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                checkMaster();
//                updateSlvaes();
//                checkDownServers();
            }
        },3000L, 3000L);

//        open();


    }

    public static void config(String master) {
        master = master;
    }

    public static void checkMaster() {
        System.out.println("检查master状态："+master);
        String masterHost = master.split(":")[0];
        int masterPort = Integer.valueOf(master.split(":")[1]);
        Jedis jedis;
        try {
            jedis = new Jedis(masterHost, masterPort);
            jedis.ping();
        } catch (Exception e) {
            System.out.println(master + "..........挂了");

        } finally {
//            jedis.close();
        }


    }
}
