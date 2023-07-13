package com.ak.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.OrderData;
import com.ak.ecomm.service.OrderService;

@RestController
@RequestMapping(value = "/order-api")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping(value = "/order")
	@PreAuthorize("hasRole('USER')")
	public void addOrder(@RequestBody OrderData orderData) {
		orderService.addOrder(orderData);
	}
	
	@GetMapping(value = "/order/userId={userId}")
	@PreAuthorize("hasRole('USER')")
	public List<OrderData> findByUserId(@PathVariable int userId){
		return orderService.findByUserId(userId);
	}
	
	@DeleteMapping(value = "/order/{orderId}")
	@PreAuthorize("hasRole('USER')")
	public void deleteOrderData(@PathVariable int orderId) {
		orderService.deleteOrderData(orderId);
	}

}
