package com.skoti.learning.controller;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.entity.Student;
import com.skoti.learning.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public Student saveStud(@RequestBody Student stud) {
		return service.saveStudent(stud);
	}
	@GetMapping("/getAllStuds")
	public List<Student> getStuds() {
		return service.getAllStudents();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Student> studById(@PathVariable("id") int id) throws StubNotFoundException {
		return service.getStudentById(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeStud(@PathVariable("id") int id) throws StubNotFoundException {
		service.deletStud(id);
	}
}
