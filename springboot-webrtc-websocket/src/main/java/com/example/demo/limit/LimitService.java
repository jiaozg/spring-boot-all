package com.example.demo.limit;

/**
 * Created by jiaozhiguang on 2017/11/22.
 */
public interface LimitService {

    boolean acquire();

    void release();

}
