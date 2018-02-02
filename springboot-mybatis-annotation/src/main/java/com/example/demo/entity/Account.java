package com.example.demo.entity;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaozhiguang on 2018/1/13.
 */
@Data
public class Account implements Delayed {

    private String id;
    private String roomId;
    private long submitTime;

    public Account(String id, String roomId) {
        this.id = id;
        this.roomId = roomId;
        this.submitTime = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Account that = (Account) o;
        return submitTime > that.submitTime? 1 :(submitTime < that.submitTime ? -1 :0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(submitTime - System.currentTimeMillis(), unit.NANOSECONDS);
    }

//    @Override
//    public String toString() {
//        return id + " " + roomId + " " + submitTime;
//    }

}
