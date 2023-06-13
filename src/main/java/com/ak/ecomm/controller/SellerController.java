package com.ak.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.Seller;
import com.ak.ecomm.service.SellerService;

@RestController
@RequestMapping(value = "/seller-api")
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	@PostMapping(value = "/seller")
	public Seller insertUser(@RequestBody Seller seller) {
		List<Seller> findByEmail = sellerService.findByEmail(seller.getEmail());
		if (findByEmail.isEmpty()) {
			return sellerService.insertSeller(seller);
		}
		return null;
	}

	@GetMapping(value = "/seller/email={email}&password={password}")
	public List<Seller> sellerDetails(@PathVariable String email, @PathVariable String password) {
		return sellerService.sellerDetails(email, password);
	}

}
