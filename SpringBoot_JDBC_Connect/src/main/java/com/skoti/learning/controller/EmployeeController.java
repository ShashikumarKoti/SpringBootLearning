package com.skoti.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.entity.Employee_Details;
import com.skoti.learning.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmp")
	public Employee_Details saveEmp(@RequestBody Employee_Details emp) {
		return employeeService.saveEmp(emp);
	}

}
