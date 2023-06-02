package com.ak.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByUserId(int userId);
	
	List<Cart> findByProductId(int productId);
	
}
