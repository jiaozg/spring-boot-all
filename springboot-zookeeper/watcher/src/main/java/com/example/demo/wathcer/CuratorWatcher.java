package com.example.demo.wathcer;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

@Component
public class CuratorWatcher {

    public static final String zookeeperConnectionString = "localhost:2181";

    private static CuratorFramework client;

    private static TreeCache treeCache;



    public static void main(String[] args) throws Exception {
        CuratorWatcher watcher = new CuratorWatcher();
        watcher.monitor();
        Thread.sleep(Long.MAX_VALUE);
    }

    public void monitor() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();

        treeCache = new TreeCache(client, "/tomcat");
        treeCache.start();
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                if (treeCacheEvent.getType() == TreeCacheEvent.Type.NODE_REMOVED) {
                    System.out.println("-=======--=======--=======- node removed" + treeCacheEvent.getData().getPath()+"-=======--=======--=======-");
                }
            }
        });
    }

}