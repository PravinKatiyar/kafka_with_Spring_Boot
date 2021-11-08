package com.pravin.apachekafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonEmployeeDashboradConsumer {

	
	@KafkaListener(topics = "t_employee",errorHandler = "EmployeeErrorHandler")
	public void consume(String msg) throws JsonMappingException, JsonProcessingException {
		if (msg.equalsIgnoreCase("emp_1015")) {
			throw new IllegalArgumentException("Exception for emp_1015 is raised!!!!");

		} else {
			System.out.println(msg);

		}
	}
}
