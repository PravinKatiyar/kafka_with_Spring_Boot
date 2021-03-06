package com.pravin.apachekafkaorder.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pravin.apachekafkaorder.broker.message.OrdersMessage;

@Service
@Component
public class Producer {

	@Autowired
	private KafkaTemplate<String, OrdersMessage> kafkaTemplate;
	private ObjectMapper objectMapper=new ObjectMapper();

	
	public void publish(OrdersMessage orderMessage) throws JsonProcessingException {
		System.out.println("message: "+orderMessage);
		kafkaTemplate.send("t_commodity.order",orderMessage);
	}
}
