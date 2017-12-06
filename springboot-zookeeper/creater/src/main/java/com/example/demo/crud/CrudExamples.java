package com.example.demo.crud;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

/**
 * 常用接口有
 create()增
 delete(): 删
 checkExists(): 判断是否存在
 setData():  改
 getData(): 查
 所有这些方法都以forpath()结尾，辅以watch(监听)，withMode（指定模式），和inBackground（后台运行）等方法来使用。
 */
public class CrudExamples {

    public static final String zookeeperConnectionString = "localhost:2181";
    private static CuratorFramework client;
    private static final String PATH = "/crud";  
  
    public static void main(String[] args) {  
        try {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
            client.start();  
  
            client.create().forPath(PATH, "I love messi".getBytes());  
  
            byte[] bs = client.getData().forPath(PATH);  
            System.out.println("新建的节点，data为:" + new String(bs));  
  
            client.setData().forPath(PATH, "I love football".getBytes());  
  
            // 由于是在background模式下获取的data，此时的bs可能为null  
            byte[] bs2 = client.getData().watched().inBackground().forPath(PATH);  
            System.out.println("修改后的data为" + new String(bs2 != null ? bs2 : new byte[0]));  
  
            client.delete().forPath(PATH);  
            Stat stat = client.checkExists().forPath(PATH);
  
            // Stat就是对zonde所有属性的一个映射， stat=null表示节点不存在！  
            System.out.println(stat);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            CloseableUtils.closeQuietly(client);
        }  
    }  
}  