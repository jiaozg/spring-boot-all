package com.example.demo.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by jiaozhiguang on 2018/3/25.
 */
public class RmiServer {

    public static void main(String[] args) throws Exception {

        String url = "rmi://localhost:1099/com.example.demo.rmi.HelloServiceImpl";
        LocateRegistry.createRegistry(1099);
        Naming.rebind(url, new HelloServiceImpl());
        System.out.println("Server stated...");

    }

}
