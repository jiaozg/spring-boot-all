package com.example.demo.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jiaozhiguang on 2017/11/19.
 */
public class Tomcat {

    public static void main(String[] args) throws IOException {

        //在服务器端开个端口
        ServerSocket server = new ServerSocket(8080);
        System.out.println("服务器启动成功！");
        while (true) {
            //接收客户端请求
            Socket socket = server.accept();
            Thread thread = new Thread(new Handler(socket));
            thread.start();
        }
    }
}
