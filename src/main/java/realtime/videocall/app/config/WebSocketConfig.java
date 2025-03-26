package realtime.videocall.app.config;

import realtime.videocall.app.handlers.ConnectionHandler;

import org.springframework.web.socket.config.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry handlerRegistry) {
        handlerRegistry.addHandler(new ConnectionHandler(), "/chat").setAllowedOrigins("*");
    }
}