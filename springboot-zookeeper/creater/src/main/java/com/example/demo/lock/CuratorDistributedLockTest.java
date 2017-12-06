package com.example.demo.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;

import java.util.concurrent.TimeUnit;

/**
 * ZooKeeper节点类型： <br>
 * ZooKeeper 节点是有生命周期的，这取决于节点的类型。<br>
 * 在 ZooKeeper 中，节点类型可以分为持久节点(PERSISTENT)、临时节点(EPHEMERAL)，以及时序节点(SEQUENTIAL)<br>
 * 具体在节点创建过程中，一般是组合使用，可以生成以下 4种节点类型<br>
 *
 * 持久节点（PERSISTENT） <br>
 * 所谓持久节点，是指在节点创建后，就一直存在，直到有删除操作来主动清除这个节点。 <br>
 * (该节点不会因为创建该节点的客户端会话失效而消失)
 *
 * 临时节点（EPHEMERAL） <br>
 * 和持久节点不同的是，临时节点的生命周期和客户端会话绑定。<br>
 * 如果客户端会话失效，那么这个节点就会自动被清除掉。<br>
 * (这里提到的是会话失效，而非连接断开)<br>
 * 另外，在临时节点下面不能创建子节点。<br>
 *
 * 持久顺序节点（PERSISTENT_SEQUENTIAL） <br>
 * 这类节点的基本特性和上面的持久节点类型是一致的。<br>
 * 额外的特性是，在ZK中，每个父节点会为他的第一级子节点维护一份时序，会记录每个子节点创建的先后顺序。 <br>
 * 基于这个特性，在创建子节点的时候，可以设置这个属性，那么在创建节点过程中，ZK会自动为给定节点名加上一个数字后缀，作为新的节点名。这个数字后缀的范围是整型的最大值。<br>
 * 假如: 我们在/lock/目录下创建节3个点，集群会按照提起创建的顺序来创建节点，节点分别为/lock/0000000001、/lock/0000000002、/lock/0000000003。
 *
 * 临时顺序节点（EPHEMERAL_SEQUENTIAL） <br>
 * 具有临时节点和顺序节点的特性。我们可以利用这个特性来实现分布式锁。 <br>
 * 基于zookeeper瞬时有序节点实现的分布式锁，其主要逻辑如下： <br>
 * 客户端对某个功能加锁时，在zookeeper上的与该功能对应的指定节点的目录下，生成一个唯一的瞬时有序节点。 <br>
 * 判断是否获取锁的方式，只需要判断有序节点中序号最小的一个，如果最小的节点与当客户端记录节点号相同获得锁<br>
 * 当释放锁的时候，只需将这个瞬时节点删除即可。 <br>
 *
 * Curator是Netflix公司开源的一个Zookeeper客户端，提供了一些操作Zookeeper的方法，其中包括创建分布式锁 <br><br> *<br> * @author _yyl
 */
public class CuratorDistributedLockTest {
 
    private static final String ZK_ADDRESS = "localhost:2181";
    private static final String ZK_LOCK_PATH = "/zktest/lock0";
 
    /**
     * 下面的程序会启动几个线程去争夺锁，拿到锁的线程会占用5秒
     */
    public static void main(String[] args) throws InterruptedException {
        // 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));
        client.start();
 
        System.out.println(client.getState());
 
        System.out.println("zk client start successfully!");
 
        InterProcessMutex lock = new InterProcessMutex(client, ZK_LOCK_PATH);
 
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                doWithLock(client, lock);
            }, "Thread-" + i).start();
        }
 
    }
 
    private static void doWithLock(CuratorFramework client, InterProcessMutex lock) {
        try {
            String name = Thread.currentThread().getName();
            if (lock.acquire(10 * 1000, TimeUnit.SECONDS)) {
 
                System.out.println(name + " hold lock");
 
                System.out.println(client.getChildren().forPath(ZK_LOCK_PATH));
 
                Thread.sleep(5000L);
                System.out.println(name + " release lock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
}