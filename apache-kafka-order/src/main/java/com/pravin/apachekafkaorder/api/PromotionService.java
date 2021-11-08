package com.pravin.apachekafkaorder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.apachekafkaorder.action.PromotionAction;
import com.pravin.apachekafkaorder.request.PromotionRequest;

@Service
public class PromotionService {
	
	@Autowired
	private PromotionAction promotionAction;
	
	public void createPromotion(PromotionRequest request) {
		promotionAction.publishToKafka(request);
	}

}
