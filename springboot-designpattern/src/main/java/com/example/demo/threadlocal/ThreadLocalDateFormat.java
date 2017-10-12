package com.example.demo.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * 实现安全的一种方式是使用锁，另一种方式是每次都创建一个新的对象，
 * 更好的方式就是使用ThreadLocal，每个线程使用自己的DateFormat，就不存在安全问题了
 */
public class ThreadLocalDateFormat {

    static ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>() {

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String date2String(Date date) {
        return sdf.get().format(date);
    }

    public static Date string2Date(String str) throws ParseException {
        return sdf.get().parse(str);
    }

}
