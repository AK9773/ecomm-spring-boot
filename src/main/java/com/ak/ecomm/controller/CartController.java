package com.ak.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.Cart;
import com.ak.ecomm.repository.CartRepository;
import com.ak.ecomm.service.CartService;

@RestController
@RequestMapping(value = "/cart-api")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping(value = "/cart")
	public Cart addToCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);
	}

	@GetMapping(value = "/cart/userId={userId}")
	public List<Cart> findByUserId(@PathVariable int userId) {
		return cartService.findByUserId(userId);
	}

	@GetMapping(value = "/cart/productId={productId}")
	public List<Cart> findByProductId(@PathVariable int productId) {
		return cartService.findByProductId(productId);
	}

	@DeleteMapping(value = "/cart/cartId={cartId}")
	public boolean deleteById(@PathVariable int cartId) {
		return cartService.deleteById(cartId);
	}

}
