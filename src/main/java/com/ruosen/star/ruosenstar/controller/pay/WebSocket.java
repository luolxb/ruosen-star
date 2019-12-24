package com.ruosen.star.ruosenstar.controller.pay;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/payment/websocket/{id}")
@Slf4j
@Component
@Data
public class WebSocket {
    //记录订单号
    private String id;
    /**
     * 当前的连接
     */
    private Session session;

    //用于存放所有订单和 websocket 连接的 map
    private static Map<String, Session> allClients = new ConcurrentHashMap<>();

    public static Map<String, Session> getAllClients() {
        return allClients;
    }

    /**
     * 当简历连接的时候调用
     *
     * @param id
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) {
        this.id = id;
        this.session = session;
        allClients.put(id, session);
    }

    @OnClose
    public void onClose(Session session) {
        allClients.remove(id);
    }

    @OnError
    public void onError(Session session, Throwable t) {
        if (session != null && session.isOpen()) {
            try {
                session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        allClients.remove(id);
    }

    /**
     * 代表客户端给服务器发送消息了,包括 两个用户之间通信也是  比如 A->B 发消息,那么是 A先给服务器发消息,告诉服务器我发给谁,服务器找到 B 的连接再将内容转过去
     * @param session
     * @param content
     */
    @OnMessage
    public void onMessage(Session session, String content) {

    }

    /**
     * 发送消息
     * @param session
     * @param message
     */
    public static  void sendMessage(Session session, String message) {
        if (session != null) {
            session.getAsyncRemote().sendText(message);
        }
    }

    /**
     * 根据 id 发送消息
     * @param id
     * @param message
     */

    public static void sendMessage(String id, String message) {
        if (id != null) {
            Session session = allClients.get(id);
            sendMessage(session,message);
        }
    }
}
