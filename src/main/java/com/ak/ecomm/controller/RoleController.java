package com.ak.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.ecomm.service.RoleService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/role-api")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostConstruct
	public void initInsertRole() {
		roleService.initInsertRole();
	}

}
