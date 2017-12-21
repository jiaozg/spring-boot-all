package com.example.demo.orderno.service.impl;

import com.example.demo.orderno.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiaozhiguang on 2017/12/15.
 */
public class OrderAtomicServiceImpl implements OrderService {

    AtomicInteger num = new AtomicInteger();
    @Override
    public String getOrderNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYmmDDHHMMSS");
        return simpleDateFormat.format(new Date()) + num.incrementAndGet();
    }
}
