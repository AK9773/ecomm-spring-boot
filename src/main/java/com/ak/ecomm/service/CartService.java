package com.ak.ecomm.service;

import java.util.List;

import com.ak.ecomm.entity.Cart;

public interface CartService {
	
	public Cart addToCart(Cart cart);

	public List<Cart> findByUserId(int userId);
	
	public List<Cart> findByProductId(int productId);
	
	public boolean deleteById(int cartId);
	
}
