package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by jiaozhiguang on 2017/11/13.
 */
public class Test {

    public static void main(String[] args) {

        Long time = null;
        Long time2 = null;
        String str = "2017-10-24 11:57:55";
        String str2 = "2017-10-24 12:57:55";
        int lastIndex = str.lastIndexOf(":");
        str = str.substring(0, lastIndex);
        str = str+":00";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date parse = df.parse(str);
            System.out.println(parse);
            Date parse2 = df.parse(str2);
            System.out.println(parse2);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(parse);
            time =calendar.getTimeInMillis();

            Calendar calendar2 = new GregorianCalendar();
            calendar2.setTime(parse2);
            time2 =calendar2.getTimeInMillis();

            //long time1 = parse2.getTime() - parse.getTime();
            //int totalS = new Long (time1 / 1000).intValue();

            System.out.println(time);
            System.out.println(time2);
            System.out.println(time2 - time);

            System.out.println(System.currentTimeMillis());


        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
