package com.messaging.rabbit.mq.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessagePublisher.class);

	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	Binding binding;

	public void sendMessage(String aMessage) {

		LOGGER.info("Sending message to the queue.");
		rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), aMessage);
		LOGGER.info("Message sent successfully to the queue!!!");

	}

}
