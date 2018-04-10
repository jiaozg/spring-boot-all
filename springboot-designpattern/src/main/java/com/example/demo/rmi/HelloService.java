package com.example.demo.rmi;

import java.rmi.Remote;

/**
 * Created by jiaozhiguang on 2018/3/25.
 */
public interface HelloService extends Remote {

    String sayHello(String string) throws Exception;

}
