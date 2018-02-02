package com.example.demo.queue;

import java.util.concurrent.DelayQueue;

/**
 * Created by jiaozhiguang on 2018/1/13.
 */
public class AccountTest {

    public static void main(String[] args) throws Exception {


        final DelayQueue<Account> bq = new DelayQueue<Account>();

        for (int i = 0; i < 5; i++) {
            Account account = new Account("账户" + i, "房间"+i);
            bq.put(account);
            Thread.sleep(1000);
        }
        while (true) {
            if (bq.isEmpty()) {
                break;
            } else {

                Account account = bq.poll();
                System.out.println("bq.peek();" + account);

//                Account account = bq.peek();
//                System.out.println("*****" + account);
//                if (account != null) {
//                    if ((System.currentTimeMillis() - account.getSubmitTime()) > 15 * 1000) {
//                        account = bq.poll();
//                        System.out.println("bq.peek();" + account);
//                    }
//
//                }
//                Thread.sleep(1000);
            }
        }

    }


}
