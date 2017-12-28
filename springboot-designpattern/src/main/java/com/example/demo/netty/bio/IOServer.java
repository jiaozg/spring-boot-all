package com.example.demo.netty.bio;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOServer.class);

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(2345));
            System.out.println("IO Server 已经启动.......端口：" + 2345);
        } catch (IOException ex) {
            LOGGER.error("Listen failed", ex);
            return;
        }
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputstream = socket.getInputStream();
                LOGGER.info("Received message {}", IOUtils.toString(inputstream));
                IOUtils.closeQuietly(inputstream);
            }
        } catch (IOException ex) {
            IOUtils.closeQuietly(serverSocket);
            LOGGER.error("Read message failed", ex);
        }
    }
}