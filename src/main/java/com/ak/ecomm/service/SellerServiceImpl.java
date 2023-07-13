package com.ak.ecomm.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.Role;
import com.ak.ecomm.entity.Seller;
import com.ak.ecomm.repository.RoleRepository;
import com.ak.ecomm.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Seller insertSeller(Seller seller) {
		List<Seller> findBySellerName = sellerRepository.findBySellerName(seller.getSellerName());
		if (findBySellerName.isEmpty()) {
			Role role = roleRepository.findById("SELLER").get();
			Set<Role> sellerRoles = new HashSet<>();
			sellerRoles.add(role);
			seller.setRole(sellerRoles);
			seller.setPassword(getEncodedPassword(seller.getPassword()));
			return sellerRepository.save(seller);
		} else {

			return null;
		}
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
