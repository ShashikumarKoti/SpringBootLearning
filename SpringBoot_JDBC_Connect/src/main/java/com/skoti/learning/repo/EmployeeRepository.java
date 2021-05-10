package com.skoti.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.Employee_Details;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee_Details, Integer>{


}
