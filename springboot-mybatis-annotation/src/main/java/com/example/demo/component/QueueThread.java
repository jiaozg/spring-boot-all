package com.example.demo.component;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Component;

/**
 * Created by jiaozhiguang on 2018/1/13.
 */
public class QueueThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (! QueueInstance.bq.isEmpty()) {

                Account account = QueueInstance.bq.peek();
                System.out.println("*****" + account);
                if (account != null) {
                    if ((System.currentTimeMillis() - account.getSubmitTime()) > 15 * 1000) {
                        account = QueueInstance.bq.poll();
                        System.out.println("bq.peek();" + account);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
