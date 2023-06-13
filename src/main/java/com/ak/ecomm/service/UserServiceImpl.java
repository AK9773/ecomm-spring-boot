package com.ak.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.ecomm.entity.User;
import com.ak.ecomm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User insertUser(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public List<User> userDetails(String email, String password) {
		
		return userRepository.userDetails(email, password);
	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	
	

}
