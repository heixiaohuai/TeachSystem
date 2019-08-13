package com.hk.utils;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Classname MsgServer
 * @Description TODO
 * @Date 2019/7/10 19:39
 * @Created by HK
 */
@ServerEndpoint("/msgServer")
public class MsgServer {
    private static CopyOnWriteArraySet<Session> sessions=new CopyOnWriteArraySet<Session>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("用户连上公告服务器...");
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(Session session,String message) throws IOException {
        System.out.println(message);
        for (Session csession : sessions) {
            if(csession.isOpen()) {
                csession.getBasicRemote().sendText(message);
            }

        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }
}
