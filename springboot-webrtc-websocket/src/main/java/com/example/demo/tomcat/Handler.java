package com.example.demo.tomcat;

import java.io.*;
import java.net.Socket;

/**
 * Created by jiaozhiguang on 2017/11/20.
 */
public class Handler implements Runnable {

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            System.out.println("接收客户端请求........");
            //读取内容  使用输入流 字节流
            InputStream in = socket.getInputStream();
            //包装成字符流
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String tmp = "";
            while ((tmp = reader.readLine()) != null && tmp.length() > 0) {
                sb.append(tmp).append("\r\n");
            }
            System.out.println(sb.toString());

            String webRoot = "/Users/jiaozhiguang/Downloads";
            String[] msgs = sb.toString().split(" ");
            FileInputStream fileIn = new FileInputStream(webRoot + msgs[1]);
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type:text/html charset:utf-8");
            writer.println();
            writer.flush();
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = fileIn.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
            fileIn.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
