package com.skoti.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.StudentAddress;

@Repository
public interface StudentAddressRepo extends JpaRepository<StudentAddress, Integer> {

}
