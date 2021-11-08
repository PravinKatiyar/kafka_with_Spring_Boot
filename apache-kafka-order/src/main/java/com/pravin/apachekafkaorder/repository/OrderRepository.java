package com.pravin.apachekafkaorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.apachekafkaorder.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
