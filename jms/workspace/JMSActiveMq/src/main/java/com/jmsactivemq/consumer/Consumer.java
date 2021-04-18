package com.jmsactivemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "axisqueue")
	public void consumeMessage(String message) {
		System.out.println("Consumed Message is: " + message);
	}
}
