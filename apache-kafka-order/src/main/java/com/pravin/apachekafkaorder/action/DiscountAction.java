package com.pravin.apachekafkaorder.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pravin.apachekafkaorder.broker.message.DiscountMessage;
import com.pravin.apachekafkaorder.producer.DiscountProducer;
import com.pravin.apachekafkaorder.request.DiscountRequest;

@Component
public class DiscountAction {

	@Autowired
	private DiscountProducer producer;

	public void publishToKafka(DiscountRequest request) {
		var message = new DiscountMessage(request.getDiscountCode(), request.getDiscountPercentage());
		producer.publish(message);
	}

}
