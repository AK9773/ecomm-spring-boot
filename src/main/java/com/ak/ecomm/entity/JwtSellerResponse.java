package com.ak.ecomm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtSellerResponse {
	
	private Seller seller;
	private String jwtToken;

}
