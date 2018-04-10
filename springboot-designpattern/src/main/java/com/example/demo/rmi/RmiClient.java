package com.example.demo.rmi;

import java.rmi.Naming;

/**
 * Created by jiaozhiguang on 2018/3/25.
 */
public class RmiClient {

    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:1099/com.example.demo.rmi.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("jiao");
        System.out.println(result);

    }

}
