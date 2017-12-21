package com.example.demo.handwrite;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/20.
 */
public class JiaoRedisProxy {

    private static List<String> servers = new ArrayList<>();

    static {
        servers.add("127.0.0.1:6379");
        servers.add("127.0.0.1:6378");
        servers.add("127.0.0.1:6377");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("启动Redis代理服务，端口：" + 19000);

        ServerSocket serverSocket = new ServerSocket(19000);
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            //负载均衡 分片存储 日志审计
            System.out.println("一个连接.....");
            InputStream inputStream = socket.getInputStream();
            byte[] request = new byte[1024];
            inputStream.read(request);

            String req = new String(request);
            System.out.println("收到请求 : " + req);

            String[] params = req.split("\r\n");
            //请求参数
            System.out.println(params);
            int keyLength = Integer.parseInt(params[3].split("\\$")[1]);

            int mod = keyLength % servers.size();
            System.out.println("根据算法选择服务器：" + servers.get(mod));

            String[] serverInfo = servers.get(mod).split(":");

            //代理请求
            Socket client = new Socket(serverInfo[0], Integer.parseInt(serverInfo[1]));
            client.getOutputStream().write(request);

            //返回结果
            byte[] response = new byte[1024];
            //获取redisServer返回结果
            client.getInputStream().read(response);
            client.close();


            socket.getOutputStream().write(response);

        }

    }
}

