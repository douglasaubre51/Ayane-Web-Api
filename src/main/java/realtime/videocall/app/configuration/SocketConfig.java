package realtime.videocall.app.configuration;

import realtime.videocall.app.handlers.*;

import org.springframework.web.socket.config.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new ConnectionHandler(), "/chat").setAllowedOrigins("*");
    }
}
