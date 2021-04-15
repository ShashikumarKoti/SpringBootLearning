package com.skoti.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.entity.User;
import com.skoti.learning.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("/loadUsers")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
}
