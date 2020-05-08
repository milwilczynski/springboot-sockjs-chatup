package com.pwsztar.chatup.configuration;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

public class MyWebSocketHandleDecorator extends WebSocketHandlerDecorator {
    public MyWebSocketHandleDecorator(WebSocketHandler delegate) {
        super(delegate);
    }

    @Override
    public void handleMessage(final WebSocketSession session, final WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage) message;
            String payload = msg.getPayload();
            if (!payload.substring(payload.length() - 1).equals("\u0000")) {
                super.handleMessage(session, new TextMessage(payload + "\u0000"));
                return;
            }
        }

        super.handleMessage(session, message);
    }
}
