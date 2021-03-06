package com.pravin.apachekafkaorder.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.pravin.apachekafkaorder.broker.message.PromotionMessage;

@Service
public class PromotionProducer {

	
	@Autowired
	private KafkaTemplate<String, PromotionMessage> kafkaTemplate;
	
	public void publishPromotionMesaage(PromotionMessage message) {
		kafkaTemplate.send("t_commodity.promotion",message);
	}


}
