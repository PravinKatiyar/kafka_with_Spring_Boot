package com.pravin.apachekafkapattern.broker.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import broker.message.OrdersMessage;

@Service
public class OrderListener {

	@KafkaListener(topics = "t.commodity.order")
	public void listen(OrdersMessage message) {
		var totalItemAmount = message.getPrice() * message.getQuantity();
		System.out.println("Processing order " + message.getOrderNumber() + ", credit card number is "
				+ message.getCreditCardNumber() + " ,Total amount for this item is " + totalItemAmount);
	}
}
