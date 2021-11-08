package com.pravin.apachekafkaproducer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class ApacheKafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private JsonEmployeeProducer jsonEmployeeProducer;

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 999; i <= 1020; i++) {
			jsonEmployeeProducer.setEmployee("emp_" + i);
		}

	}

}
