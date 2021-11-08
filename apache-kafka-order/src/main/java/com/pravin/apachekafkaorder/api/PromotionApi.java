package com.pravin.apachekafkaorder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.apachekafkaorder.request.PromotionRequest;

@RestController
public class PromotionApi {

	@Autowired
	private PromotionService promotionService;

	@PostMapping(value = "/promotion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody PromotionRequest request) {
		promotionService.createPromotion(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(request.getPromotionCode());
	}
}
