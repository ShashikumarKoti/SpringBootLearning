package com.skoti.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
