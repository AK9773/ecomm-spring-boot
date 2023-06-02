package com.ak.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.Cart;
import com.ak.ecomm.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart addToCart(Cart cart) {
	return cartRepository.save(cart);
		
	}
	
	@Override
	public List<Cart> findByUserId(int userId) {
		return cartRepository.findByUserId(userId);
	}

	@Override
	public List<Cart> findByProductId(int productId) {
		return cartRepository.findByProductId(productId);
	}

	@Override
	public boolean deleteById(int cartId) {
		cartRepository.deleteById(cartId);
		return true;
		
	}

}
