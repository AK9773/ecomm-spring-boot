package com.ak.ecomm.service;

import java.util.List;

import com.ak.ecomm.entity.OrderData;

public interface OrderService {
	
	public void addOrder(OrderData orderData);
	
	public List<OrderData> findByUserId(int userId);
	
	public void deleteOrderData(int orderId);

}
