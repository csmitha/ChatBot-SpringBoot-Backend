package com.mskcc.chat.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


/**
* The WebSocketConfig program implements  WebSocketMessageBrokerConfigurer that
* registers Stomp end point and configures message broker.
*
* @author  Smitha Chap
* @version 1.0
* @since   2019-09-02
*/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws/*").setAllowedOrigins("*").withSockJS();
		registry.addEndpoint("/**").setAllowedOrigins("*");
		registry.addEndpoint("/loginUser/**").setAllowedOrigins("*");	
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");

	}

}
