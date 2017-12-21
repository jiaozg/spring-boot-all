package com.example.demo.orderno.service.impl;

import com.example.demo.orderno.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderLockServiceImpl implements OrderService {
    int num;
    @Override
    public synchronized String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + num++;
    }
}
