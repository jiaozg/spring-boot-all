package com.example.demo.createor;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorCreateNode {

    public static final String zookeeperConnectionString = "localhost:2181";

    private static final String ZK_PATH = "/tomcat/";

    private static CuratorFramework client;


    public CuratorCreateNode(String name) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();

        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                .forPath(ZK_PATH + name, name.getBytes());
        System.out.println("创建节点成功");
    }

    public static void main(String[] args) throws Exception {
        CuratorCreateNode curatorCreateNode = new CuratorCreateNode("tomcat001");
    }

}