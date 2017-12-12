package com.example.demo.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static final String WEB_ROOT = System.getProperty("user.dir");
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8088;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
            System.out.println("Tomcat started on port(s): "+port+" (http)");
        } catch (Exception e) {
            e.printStackTrace();
//            System.exit(1);
        }
        while (!shutdown) {
            Socket socket = null;
            InputStream in = null;
            OutputStream out = null;
            try {
                socket = serverSocket.accept();
                in = socket.getInputStream();
                out = socket.getOutputStream();
                Request request = new Request(in);
                request.parse();
                Response response = new Response(out);
                response.setRequest(request);
                response.sendStaticResource();
                socket.close();
                if (request.getUri() != null) {
                    shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
                }

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}  