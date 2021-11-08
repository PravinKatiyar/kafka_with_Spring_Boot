package com.pravin.apachekafkaconsumer;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pravin.apachekafkaconsumer.Errorhandler.GlobalErrorHandler;

@Configuration
public class KafkaConfig {

	@Autowired
	private KafkaProperties kafkaProperties;

	@Bean
	public ConsumerFactory<Object, Object> consumerFactory() {
		var properties = kafkaProperties.buildConsumerProperties();

		properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "180000");// Change default refresh rate for kafka
																			// Rebalancing
		return new DefaultKafkaConsumerFactory<Object, Object>(properties);
	}

//	@Bean(name = "farLocationContainerFactory")
//	public ConcurrentKafkaListenerContainerFactory<Object, Object> farLocationContainerFactory(
//			ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
//		var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
//		configurer.configure(factory, consumerFactory());
//
//		factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {
//			ObjectMapper objectMapper = new ObjectMapper();
//
//			@Override
//			public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
//				
//				try {
//					var emp = objectMapper.readValue(consumerRecord.value().toString(), Employee.class);
//					return emp.getEmpId().equals("1001014");
//
//				} catch (IOException e) {
//					return false;
//				}
//
//			}
//
//		});
//		return factory;
//	}
	
	@Bean(name = "kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(
			ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
		configurer.configure(factory, consumerFactory());
		factory.setErrorHandler(new GlobalErrorHandler());
		return factory;
	}
	
}


