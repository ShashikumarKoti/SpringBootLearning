package com.skoti.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.entity.Student;
import com.skoti.learning.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStud")
	public Student saveStudent(@RequestBody Student stud) {
		return studentService.saveStud(stud);
	}
	
	@GetMapping("/getAllStuds")
	public List<Student> getAllStudents() {
		return studentService.getAllStuds();
	}
	
	@DeleteMapping("/deleteStud/{id}")
	public void deletStud(@PathVariable("id")  int studID) {
		studentService.deleteStud(studID);
	}
	
	@PutMapping("updateStud/{id}")
	public Student updateStud(@PathVariable("id") int studID, @RequestBody Student stud) {
		return studentService.updateStud(studID, stud);
	}
}
