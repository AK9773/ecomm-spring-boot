package com.ak.ecomm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.Product;
import com.ak.ecomm.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public void updateProduct(int productId, Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> findBySellerId(int sellerId) {
		return productRepository.findBySellerId(sellerId);
	}

	@Override
	public List<Product> searchProduct(String query) {
		return productRepository.searchProduct(query);
	}

	

}
