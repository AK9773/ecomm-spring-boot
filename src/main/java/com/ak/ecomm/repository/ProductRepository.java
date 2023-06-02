package com.ak.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findBySellerId(int sellerId);
	
	List<Product> searchProduct(String query);


}
