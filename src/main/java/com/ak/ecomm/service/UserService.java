package com.ak.ecomm.service;

import java.util.List;
import com.ak.ecomm.entity.User;

public interface UserService {

	public void insertUser(User user);
	
	public List<User> userDetails(String email, String password);
	

}
