package com.ak.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.Seller;
import com.ak.ecomm.service.SellerService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/seller-api")
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@PostMapping(value = "/seller")
	public Seller insertUser(@RequestBody Seller seller) {
		return sellerService.insertSeller(seller);
	}

}
