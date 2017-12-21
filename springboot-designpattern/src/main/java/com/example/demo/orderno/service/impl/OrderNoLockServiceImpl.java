package com.example.demo.orderno.service.impl;

import com.example.demo.orderno.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderNoLockServiceImpl implements OrderService {
    int num;
    @Override
    public String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + num++;
    }
}
