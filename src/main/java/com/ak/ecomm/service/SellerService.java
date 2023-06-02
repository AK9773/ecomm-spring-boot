package com.ak.ecomm.service;

import java.util.List;

import com.ak.ecomm.entity.Seller;

public interface SellerService {

	public void insertSeller(Seller seller);

	public List<Seller> sellerDetails(String email, String password);

}
