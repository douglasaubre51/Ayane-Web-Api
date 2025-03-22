package realtime.videocall.app.handlers;

import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import javax.websocket.Session;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.CloseStatus;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ConnectionHandler extends AbstractWebSocketHandler {
    private List<Session> webSocketSession = Collections.synchronizedList(new ArrayList<>());
    private Map<String, Long> clients = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void afterConnectionEstablished(Session session) throws Exception {
        super.afterConnectionEstablished(session);

        System.out.println("user" + session.getId() + " connected to server");
        webSocketSession.add(session);

        session.sendMessage(new TextMessage(session.getId()));
    }

    @Override
    public void afterConnectionClosed(Session session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);

        System.out.println("user " + session.getId() + "disconnected");
        webSocketSession.remove(session);
    }

    @Override
    public void handleTextMessage(Session session, TextMessage message) throws Exception {

    }
}
