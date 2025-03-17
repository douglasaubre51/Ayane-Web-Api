package realtime.videocall.app.handlers;

import org.springframework.web.socket.handler.*;
import org.springframework.web.socket.*;
import java.util.*;

public class ConnectionHandler extends TextWebSocketHandler {
    List<WebSocketSession> webSocketSession = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        System.out.println("user" +
                session.getId() + " connected to server");
        webSocketSession.add(session);

        session.sendMessage(new TextMessage("welcome to soul society!"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);

        System.out.println("user " + session.getId() + "disconnected");
        webSocketSession.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        for (WebSocketSession s : webSocketSession) {
            if (s != session) {
                s.sendMessage(message);
            }
        }
    }
}
