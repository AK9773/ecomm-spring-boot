package com.ak.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.Role;
import com.ak.ecomm.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}


	@Override
	public void initInsertRole() {
		Role userRole= new Role("USER", "User role for application");
		Role sellerRole= new Role("SELLER", "Seller role for application");
		roleRepository.save(userRole);
		roleRepository.save(sellerRole);
		
	}

}
