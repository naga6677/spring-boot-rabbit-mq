package com.messaging.rabbit.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.messaging.rabbit.mq.component.MessagePublisher;

@SpringBootApplication
public class RabbitMqApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqApplication.class);

	@Autowired
	private MessagePublisher messagePublisher;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String tHeloArray[] = { "Hello World!!", "Hello Venkat!!", "Hello RabbitMQ!!" };

		for (String aMessage : tHeloArray) {
			LOGGER.info("Sending message to the queue."+ aMessage);
			messagePublisher.sendMessage(aMessage);
			LOGGER.info("Message sent successfully to the queue!!!");
		}

	}

}
