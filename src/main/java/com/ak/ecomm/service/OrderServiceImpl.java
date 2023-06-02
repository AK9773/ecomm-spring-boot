package com.ak.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.OrderData;
import com.ak.ecomm.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void addOrder(OrderData orderData) {
		orderRepository.save(orderData);
		
	}

	@Override
	public List<OrderData> findByUserId(int userId) {
		return orderRepository.findByUserId(userId);
	}

	@Override
	public void deleteOrderData(int orderId) {
		orderRepository.deleteById(orderId);
	}

}
