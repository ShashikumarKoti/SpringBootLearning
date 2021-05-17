package com.skoti.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.SecureUser;

@Repository
public interface UserRepository extends JpaRepository<SecureUser, Integer>{

	SecureUser findByUserName(String username);

}
