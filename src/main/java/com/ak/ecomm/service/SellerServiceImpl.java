package com.ak.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.Seller;
import com.ak.ecomm.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public void insertSeller(Seller seller) {
		sellerRepository.save(seller);
		
	}

	@Override
	public List<Seller> sellerDetails(String email, String password) {
		return sellerRepository.sellerDetails(email, password);
	}
}
