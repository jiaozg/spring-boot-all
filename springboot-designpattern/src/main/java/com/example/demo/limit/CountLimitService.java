package com.example.demo.limit;

/**
 * Created by jiaozhiguang on 2017/11/22.
 */
public class CountLimitService implements LimitService {

    int limit = 60;//限制综述
    int request = 0;
    long start = System.currentTimeMillis();
    int interval = 60; //间隔时间

    @Override
    public boolean acquire() {
        long now = System.currentTimeMillis();
        if (now > start + interval) {
            start = now;
            request = 0;
            return true;
        }
        request++;
        return request < limit;
    }

    @Override
    public void release() {

    }
}
