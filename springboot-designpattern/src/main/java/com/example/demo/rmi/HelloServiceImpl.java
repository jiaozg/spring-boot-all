package com.example.demo.rmi;

import java.rmi.server.UnicastRemoteObject;

/**
 * Created by jiaozhiguang on 2018/3/25.
 */

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws Exception {

    }

    @Override
    public String sayHello(String string) throws Exception{
        System.out.println(string);
        return "Hello " + string;
    }
}
