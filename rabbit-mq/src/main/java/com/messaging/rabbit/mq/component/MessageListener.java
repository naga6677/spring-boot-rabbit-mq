package com.messaging.rabbit.mq.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageListener.class);

	@Autowired
	Queue queue;

	@RabbitListener(queues = "#{qu.getName()}")
	public void getMsg(final String message) {
		LOGGER.info("Getting messages.....");
		LOGGER.info("Finally Receiver received the message and the message  is: " + message);
	}
}
