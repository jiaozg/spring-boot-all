package com.example.demo.handwrite;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jiaozhiguang on 2017/12/20.
 */
public class RedisServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(6378);

        System.out.println("Redis服务器启动完成.... 在端口：6378");

        Socket socket = serverSocket.accept();



        byte[] request = new byte[1024];

        InputStream inputStream = socket.getInputStream();

        inputStream.read(request);

        System.out.println(new String(request));

    }

}
