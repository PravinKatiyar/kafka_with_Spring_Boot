package com.pravin.apachekafkaorder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.apachekafkaorder.action.DiscountAction;
import com.pravin.apachekafkaorder.request.DiscountRequest;

@Service
public class DiscountService {

	@Autowired
	private DiscountAction action;

	public void createDiscount(DiscountRequest request) {
		action.publishToKafka(request);
	}

}
