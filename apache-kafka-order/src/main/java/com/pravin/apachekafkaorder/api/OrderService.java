package com.pravin.apachekafkaorder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pravin.apachekafkaorder.action.OrderAction;
import com.pravin.apachekafkaorder.entity.Order;
import com.pravin.apachekafkaorder.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
	private OrderAction orderAction;


	public String saveOrder(OrderRequest orderRequest) {
		// Convert OrderRequest to Order
		Order order=orderAction.convertToOrder(orderRequest);
		//Save Order to Database
	
		orderAction.saveToDatabase(order);
		//Flatten the items & ordre as kafka message, and publish
		order.getItems().forEach(t -> {
			try {
				orderAction.publishToKafka(t);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		return order.getOrderNumber();
	}

}
