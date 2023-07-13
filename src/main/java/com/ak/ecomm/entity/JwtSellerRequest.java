package com.ak.ecomm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtSellerRequest {

	private String sellerName;
	private String password;

}
