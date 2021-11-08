package com.pravin.apachekafkaconsumer.Errorhandler;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Service(value="EmployeeErrorHandler")
public class ErrorHandler implements ConsumerAwareListenerErrorHandler{


	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
		System.out.println("Error is raised successfully, message: "+message.getPayload());
		return null;
	}

}
