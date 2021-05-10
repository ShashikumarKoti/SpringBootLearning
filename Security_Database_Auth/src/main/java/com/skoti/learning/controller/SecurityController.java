package com.skoti.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.entity.Users;
import com.skoti.learning.service.UserService;

@RestController
public class SecurityController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/greet/{msg}")
	public String greet(@PathVariable("msg") String message) {
		return "Welcome to spring boot auth";
	}
	
	@PostMapping("/saveUser")
	public Users saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

}
