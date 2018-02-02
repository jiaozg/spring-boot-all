package com.example.demo.web;

import com.example.demo.component.QueueInstance;
import com.example.demo.entity.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2018/1/13.
 */
@RestController
public class AccountController {

    @GetMapping("/account")
    public String account() throws Exception {

        for (int i = 0; i < 5; i++) {
            Account account = new Account("账户" + i, "房间" + i);
            QueueInstance.bq.put(account);
            Thread.sleep(1000);
        }

        return "OK";
    }

}
