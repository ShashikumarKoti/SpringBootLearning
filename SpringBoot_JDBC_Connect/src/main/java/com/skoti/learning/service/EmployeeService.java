package com.skoti.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.Employee_Details;
import com.skoti.learning.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee_Details saveEmp(Employee_Details emp) {
		return employeeRepository.save(emp);
	}
}
