package com.skoti.learning.repositoy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.User;

@Repository
public class UserRepository {

	public List<User> getAllUsers() {
		return Stream.of(
				new User(111, "Amod", "amod@ggg.com", "active"),
				new User(222, "Mohan", "mohan@mmm.com", "inactive"),
				new User(333, "ramesh", "ramesh@rrr.com", "active")
				).collect(Collectors.toList());
	}
	
	//To get count of active/inactive users
	public long getUserStatusCount(String status) {
		return getAllUsers().stream().filter(user -> user.getStatus().equals(status)).count();
	}
}
