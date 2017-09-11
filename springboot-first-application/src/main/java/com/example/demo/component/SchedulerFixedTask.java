package com.example.demo.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiaozhiguang on 2017/9/4.
 */
@Component
public class SchedulerFixedTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }

    private int count=0;

    @Scheduled(cron="0 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++) + "  " +  new Date());
    }

}
