package com.pravin.apachekafkaorder.api;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.apachekafkaorder.request.OrderRequest;

@RestController
public class OrderApi {
	
	@Autowired
	private OrderService service;
	
	@PostMapping(value="/saveOrder", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
		
		String orderNumber=service.saveOrder(orderRequest);
		
		OrderResponse orderResponse=new OrderResponse(orderNumber);
		return ResponseEntity.ok().body(orderResponse);
	}
}
