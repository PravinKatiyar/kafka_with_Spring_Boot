package com.pravin.apachekafkaorder.action;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pravin.apachekafkaorder.broker.message.OrdersMessage;
import com.pravin.apachekafkaorder.entity.Order;
import com.pravin.apachekafkaorder.entity.OrderItem;
import com.pravin.apachekafkaorder.producer.Producer;
import com.pravin.apachekafkaorder.repository.OrderItemRepository;
import com.pravin.apachekafkaorder.repository.OrderRepository;
import com.pravin.apachekafkaorder.request.OrderItemRequest;
import com.pravin.apachekafkaorder.request.OrderRequest;

@Component
public class OrderAction {

	@Autowired
	private Producer orderProducer;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public Order convertToOrder(OrderRequest orderRequest) {
		var result = new Order();

		result.setCreditCardNumber(orderRequest.getCreditCardNumber());
		result.setOrderLocation(orderRequest.getOrderLocation());
		result.setOrderDateTime(LocalDateTime.now());
		result.setOrderNumber(RandomStringUtils.randomAlphanumeric(8).toUpperCase());
		

		List<OrderItem> items = orderRequest.getItems().stream().map(this::convertToOrderItem)
				.collect(Collectors.toList());

		items.forEach(item -> item.setOrder(result));
		result.setItems(items);

		return result;
	}

	private OrderItem convertToOrderItem(OrderItemRequest itemRequest) {
		var result = new OrderItem();
		result.setItemName(itemRequest.getItemName());
		result.setPrice(itemRequest.getPrice());
		result.setQuantity(itemRequest.getQuantity());
		System.out.println(itemRequest.getItemName());
		return result;
	}

	public void saveToDatabase(Order order) {
		orderRepository.save(order);
		System.out.println("saveToDatabase");
		order.getItems().forEach(orderItemRepository::save);
	}

	public void publishToKafka(OrderItem item) throws JsonProcessingException {
		var orderMessage = new OrdersMessage();

		orderMessage.setItemName(item.getItemName());
		orderMessage.setPrice(item.getPrice());
		orderMessage.setQuantity(item.getQuantity());
		orderMessage.setCreditCardNumber(item.getOrder().getCreditCardNumber());
		orderMessage.setOrderDateTime(item.getOrder().getOrderDateTime());
		orderMessage.setOrderLocation(item.getOrder().getOrderLocation());
		orderMessage.setOrderNumber(item.getOrder().getOrderNumber());
		System.out.println(orderMessage);
		

		orderProducer.publish(orderMessage);

	}

}
