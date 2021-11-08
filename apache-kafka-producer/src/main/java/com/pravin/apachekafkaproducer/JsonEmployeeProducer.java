package com.pravin.apachekafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class JsonEmployeeProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void setEmployee(String msg) throws JsonProcessingException {
		kafkaTemplate.send("t_employee", msg);
	}

}
