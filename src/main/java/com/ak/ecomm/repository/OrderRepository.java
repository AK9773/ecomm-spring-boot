package com.ak.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.OrderData;

public interface OrderRepository extends JpaRepository<OrderData, Integer> {

	
	List<OrderData> findByUserId(int userId);
}
