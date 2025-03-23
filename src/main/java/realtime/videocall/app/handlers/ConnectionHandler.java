package realtime.videocall.app.handlers;

import org.springframework.web.socket.server.standard.SpringConfigurator;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;

//i added the springconfigurator.class since server endpoints are not detected by spring
@ServerEndpoint(value = "/stream", configurator = SpringConfigurator.class)
public class ConnectionHandler {
    private List<Session> Sessions = Collections.synchronizedList(new ArrayList<>());
    // private Map<String, Long> ClientSessions = Collections.synchronizedMap(new
    // HashMap<>());

    @OnOpen
    private void OnClientConnection(Session session) {
        System.out.println("client connected: " + session.getId());
        Sessions.add(session);
        session.getAsyncRemote().sendText("yokoso! watashi no soul society ye!");
    }

    @OnClose
    private void OnClientDisconnection(Session session) {
        System.out.println("client disconnected: " + session.getId());
        Sessions.remove(session);
    }

    @OnError
    private void onClientConnectionError(Session session) {
        System.out.println("client disconnected: " + session.getId());
    }
}