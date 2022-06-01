package com.messaging.rabbit.mq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.messaging.rabbit.mq.component.MessagePublisher;

@RestController
public class RabbitMQController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQController.class);

	@Autowired
	private MessagePublisher messagePublisher;

	@GetMapping(value = "/send/{msg}")
	@ResponseStatus(code = HttpStatus.OK)
	public String send(@PathVariable("msg") final String aMessage) {

		LOGGER.info("Sending message to the queue.");
		messagePublisher.sendMessage(aMessage);
		LOGGER.info("Message sent successfully to the queue!!!");

		return "Great!! your message is sent";
	}

}
