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
	public void insertUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public List<User> userDetails(String email, String password) {
		
		return userRepository.userDetails(email, password);
	}

	
	
	

}
