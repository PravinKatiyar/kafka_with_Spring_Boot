package com.pravin.apachekafkaorder.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pravin.apachekafkaorder.broker.message.PromotionMessage;
import com.pravin.apachekafkaorder.producer.PromotionProducer;
import com.pravin.apachekafkaorder.request.PromotionRequest;

@Component
public class PromotionAction {

	@Autowired
	private PromotionProducer promotionProducer;

	public void publishToKafka(PromotionRequest request) {
		var message = new PromotionMessage(request.getPromotionCode());
		promotionProducer.publishPromotionMesaage(message);
	}

}
