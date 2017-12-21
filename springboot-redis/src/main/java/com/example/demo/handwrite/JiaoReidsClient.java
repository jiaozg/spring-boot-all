package com.example.demo.handwrite;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by jiaozhiguang on 2017/12/20.
 *
 * https://redis.io/topics/protocol
 */
public class JiaoReidsClient {

    Socket socket;
    InputStream reader;
    OutputStream writer;

    public JiaoReidsClient() throws Exception {
        socket = new Socket("127.0.0.1", 6379);
        reader = socket.getInputStream();
        writer = socket.getOutputStream();
    }
    //set tony hello
//*3 参数数量
//$3 第一个参数长度
//SET 第一个参数
//$4
//tony
//$5
//hello
    public String set(String key, String value) throws Exception {
        StringBuilder cmmond = new StringBuilder();
        cmmond.append("*3").append("\r\n");
        cmmond.append("$3").append("\r\n");
        cmmond.append("SET").append("\r\n");
        cmmond.append("$").append(key.getBytes().length).append("\r\n");
        cmmond.append(key).append("\r\n");
        cmmond.append("$").append(value.getBytes().length).append("\r\n");
        cmmond.append(value).append("\r\n");

        return execCommond(cmmond);
    }

    public String get(String key) throws Exception {
        StringBuilder cmmond = new StringBuilder();
        cmmond.append("*2").append("\r\n");
        cmmond.append("$3").append("\r\n");
        cmmond.append("GET").append("\r\n");
        cmmond.append("$").append(key.getBytes().length).append("\r\n");
        cmmond.append(key).append("\r\n");


        return execCommond(cmmond);
    }

    public String execCommond(StringBuilder commond) throws Exception {
        writer.write(commond.toString().getBytes());

        byte[] bytes = new byte[1024];
        reader.read(bytes);
        return new String(bytes);
    }

}
