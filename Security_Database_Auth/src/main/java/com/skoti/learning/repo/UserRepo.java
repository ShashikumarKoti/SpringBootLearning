package com.skoti.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

}
