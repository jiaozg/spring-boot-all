package com.example.demo.handwrite;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
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
                updateSlvaes();
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
        Jedis jedis = null;
        try {
            jedis = new Jedis(masterHost, masterPort);
            jedis.ping();
        } catch (Exception e) {
            System.out.println(master + "..........挂了");
            downServers.add(master);

            changeMaster();

        } finally {
            jedis.close();
        }
    }

    public static void changeMaster() {
        Iterator<String> iterator = slaves.iterator();
        while (iterator.hasNext()) {
            String slave = iterator.next();
            try {
                String slaveHost = slave.split(":")[0];
                int slavePort = Integer.valueOf(slave.split(":")[1]);
                Jedis jedis = new Jedis(slaveHost, slavePort);
                //你来当老大
                jedis.slaveofNoOne();
                jedis.close();
                master = slave;
                System.out.println("产生新的master " + master);
                break;
            } catch (Exception e) {
                downServers.add(slave);
            } finally {
                iterator.remove();
            }
        }

        //所有slave切换到新的master
        for (String slave : slaves) {
            String savleHost = slave.split(":")[0];
            int slavePort = Integer.valueOf(slave.split(":")[1]);

            Jedis jedis = new Jedis(savleHost, slavePort);
            jedis.slaveof(master.split(":")[0], Integer.valueOf(master.split(":")[1]));
            jedis.close();

        }
    }

    private static void updateSlvaes() {
        try {
            String masterHost = master.split(":")[0];
            int masterPort = Integer.valueOf(master.split(":")[1]);

            Jedis jedis = new Jedis(masterHost, masterPort);
            String info_replication = jedis.info("replication");

            String[] lines = info_replication.split("\r\n");
            int slaveCount = Integer.valueOf(lines[2].split(":")[1]);
            if (slaveCount > 0) {
                slaves.clear();
                for (int i = 0; i < slaveCount; i++) {

                }
            }
        } catch (Exception e) {

        }

    }
}
