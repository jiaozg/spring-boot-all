package com.example.demo.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jiaozhiguang on 2017/11/20.
 */
public class SocketDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8989);
        System.out.println("启动服务成功");
        Socket socket = server.accept();
        System.out.println("接收客户端请求.........");
        while (true) {
            InputStream in = socket.getInputStream();
            byte[] buf = new byte[1024];

            while (true) {
                int data = in.read();
                if (data != -1) {
                    String info = new String(buf, 0, data, "utf-8");
                    System.out.println(info);
                } else {
                    break;
                }
            }
        }

    }

}
