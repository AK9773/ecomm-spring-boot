package com.ak.ecomm.service;

import java.util.List;
import com.ak.ecomm.entity.User;

public interface UserService {

	public User insertUser(User user);
	
	public List<User> findByEmail(String email);
	
	public List<User> userDetails(String email, String password);
	

}
