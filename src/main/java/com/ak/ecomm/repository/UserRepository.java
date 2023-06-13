package com.ak.ecomm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.ecomm.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> userDetails(String email, String password);
	
	List<User> findByEmail(String email);

}
