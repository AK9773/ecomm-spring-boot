package com.ak.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

	List<Seller> findBySellerName(String sellerName);

}
