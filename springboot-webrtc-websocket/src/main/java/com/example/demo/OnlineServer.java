package com.example.demo;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by jiaozhiguang on 2017/10/25.
 * 当客户端访问／onlineServer连接的时候，创建一个OnlineServer的实例
 */
//指定一个URI
@ServerEndpoint("/onlineServer")
public class OnlineServer {

    //当前会话对象，通过session 服务器可以向客户发送消息
    private Session session;

    //建立一个线程安全的静态集合 存储所有客户端的实例
    public static Vector<OnlineServer> clints = new Vector<>();

    //当客户端 与 服务器 建立连接 时 触发方法
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        clints.add(this);
        System.out.println("新连接 建立" + clints.size());
    }

    @OnClose
    public void onClose(Session session) {
        clints.remove(this);
        System.out.println("有一个连接断开");
    }

    //客户端向服务器发消息时触发
    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        //群发消息
        for (OnlineServer client : clints) {
            client.session.getBasicRemote().sendText(message);
        }
    }

}
