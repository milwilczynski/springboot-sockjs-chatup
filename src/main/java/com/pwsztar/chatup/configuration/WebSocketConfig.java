package com.pwsztar.chatup.configuration;
import com.pwsztar.chatup.controller.ChatController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
    public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);
        @Override
        public void registerStompEndpoints(StompEndpointRegistry registry) {
            LOGGER.info("Registry: ", registry);
            registry.addEndpoint("/chat").withSockJS();
        }

        @Override
        public void configureMessageBroker(MessageBrokerRegistry registry) {
            registry.enableSimpleBroker("/topic");
            registry.setApplicationDestinationPrefixes("/app");
        }


}
