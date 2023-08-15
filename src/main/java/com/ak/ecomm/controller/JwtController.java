package com.ak.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.JwtSellerRequest;
import com.ak.ecomm.entity.JwtSellerResponse;
import com.ak.ecomm.entity.JwtUserRequest;
import com.ak.ecomm.entity.JwtUserResponse;
import com.ak.ecomm.service.JwtService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {

	@Autowired
	private JwtService jwtService;

	@PostMapping(value = "/authenticate/user")
	public JwtUserResponse createUserJwtToken(@RequestBody JwtUserRequest jwtRequest) throws Exception {
		return jwtService.createUserJwtToken(jwtRequest);
	}

	@PostMapping(value = "/authenticate/seller")
	public JwtSellerResponse createSellerJwtToken(@RequestBody JwtSellerRequest jwtRequest) throws Exception {
		return jwtService.createSellerJwtToken(jwtRequest);
	}

	@GetMapping(value = "/userId/{jwtToken}")
	public int getUserIdFromJwtToken(@PathVariable String jwtToken) {
		return jwtService.getUserIdFromJwtToken(jwtToken);
	}

	@GetMapping(value = "/sellerId/{jwtToken}")
	public int getSellerIdFromJwtToken(@PathVariable String jwtToken) {
		return jwtService.getSellerIdFromJwtToken(jwtToken);
	}

}
