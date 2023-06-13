package com.ak.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.User;
import com.ak.ecomm.service.UserService;

@RestController
@RequestMapping(value = "/user-api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/user")
	public User insertUser(@RequestBody User user) {
		List<User> findByEmail = userService.findByEmail(user.getEmail());
		if (findByEmail.isEmpty()) {
			return userService.insertUser(user);
		} else {
			return null;
		}

	}

	@GetMapping(value = "/user/email={email}&password={password}")
	public List<User> userDetails(@PathVariable String email, @PathVariable String password) {
		return userService.userDetails(email, password);
	}

}
