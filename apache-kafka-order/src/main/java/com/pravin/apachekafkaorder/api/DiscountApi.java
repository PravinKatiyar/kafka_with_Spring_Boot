package com.pravin.apachekafkaorder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.apachekafkaorder.request.DiscountRequest;

@RestController
public class DiscountApi {

	@Autowired
	private DiscountService service;

	@PostMapping(value = "/discount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody DiscountRequest request) {
		service.createDiscount(request);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(request.getDiscountCode() + " with " + request.getDiscountPercentage() + "% discount");
	}

}
