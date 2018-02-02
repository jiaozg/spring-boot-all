package com.example.demo.component;

import com.example.demo.entity.Account;

import java.util.concurrent.DelayQueue;

/**
 * Created by jiaozhiguang on 2018/1/13.
 */
public class QueueInstance {

    public static final DelayQueue<Account> bq = new DelayQueue<Account>();

}
