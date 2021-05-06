package com.skoti.learning.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.Student;
import com.skoti.learning.exception.StudentNotFoundException;
import com.skoti.learning.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;

	public Student saveStudent(Student stud) {
		Student student = studentRepo.save(stud);
		return student;
	}
	
	public List<Student> getAllStudents() {
		List<Student> allStud = studentRepo.findAll();
		return allStud;
	}
	
	public Optional<Student> getStudentById(int id) throws StubNotFoundException {
		Optional<Student> findById = studentRepo.findById(id);
		if(!findById.isPresent())
			throw new StudentNotFoundException("Student with Id: "+ id + " not found");
		return findById;
	}
	
	public void deletStud(int id) throws StubNotFoundException {
		getStudentById(id);
		studentRepo.deleteById(id);
	}
}
