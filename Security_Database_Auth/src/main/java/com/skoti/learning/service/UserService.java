package com.skoti.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.Users;
import com.skoti.learning.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public Users saveUser(Users user) {
		return userRepo.save(user);
	}

}
