package com.ak.ecomm.service;

import java.util.List;

import com.ak.ecomm.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProduct(int productId);

	public void updateProduct(int productId, Product product);

	public void deleteProduct(int productId);

	public List<Product> findBySellerId(int sellerId);
	
	public List<Product> searchProduct(String query);
	

}
