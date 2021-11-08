package com.pravin.apachekafkaconsumer.Errorhandler;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;

public class GlobalErrorHandler implements ConsumerAwareErrorHandler {

	@Override
	public void handle(Exception thrownException, ConsumerRecord<?, ?> data, Consumer<?, ?> consumer) {
		System.out.println("Global Error Handler: "+data.value().toString());
	}

}
