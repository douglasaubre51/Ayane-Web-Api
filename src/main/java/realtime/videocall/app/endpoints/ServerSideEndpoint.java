package realtime.videocall.app.endpoints;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.websocket.Session;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;

import realtime.videocall.app.entities.*;
import realtime.videocall.app.repositories.IUserRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@ServerEndpoint("/stream")
public class ServerSideEndpoint {
    @Autowired
    private IUserRepository _userRepository;

    private List<Session> webSocketSessions = Collections.synchronizedList(new ArrayList<>());
    private Map<Long, Session> clients = Collections.synchronizedMap(new HashMap<>());

    @OnOpen
    public void newClientConnected(Session session) throws Exception {
        System.out.println("client connected: " + session.getId());

        session.getAsyncRemote().sendText(session.getId());

        webSocketSessions.add(session);
    }

    @OnClose
    public void clientDisconnected(Session session) {
        System.out.println("client disconnected: " + session.getId());

        webSocketSessions.remove(session);
    }

    @OnError
    public void clientConnectionError(Session session) {
        System.out.println("connection error: " + session.getId());

    }

    @OnMessage
    public void clientMessenger(Long id, String sessionId) {
        for (Session s : webSocketSessions) {
            if (s.getId() == sessionId) {
                clients.put(id, s);
                System.out.println("clients list: " + clients);

                User user = _userRepository.findById(id).orElse(null);

                s.getAsyncRemote().sendText("client session: " + user.getName());
            }
        }
    }

    @OnMessage
    public void sendMessage(Long id, String message) {

    }
}
