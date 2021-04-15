package com.skoti.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.User;
import com.skoti.learning.repositoy.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
}
