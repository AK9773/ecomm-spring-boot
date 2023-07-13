package com.ak.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.entity.User;
import com.ak.ecomm.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/user-api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/user")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);

	}

}