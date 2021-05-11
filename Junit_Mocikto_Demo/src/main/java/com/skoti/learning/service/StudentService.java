package com.skoti.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.Student;
import com.skoti.learning.entity.StudentAddress;
import com.skoti.learning.repo.StudentAddressRepo;
import com.skoti.learning.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private StudentAddressService studentAddressService;

	public Student saveStud(Student stud) {
		Student savedStud = studentRepo.save(stud);
		studentAddressService.saveStudAddr(savedStud);
		return savedStud;

	}

	public List<Student> getAllStuds() {
		System.out.println("Student service called");
		studentAddressService.getAllStudAddress();
		return studentRepo.findAll();
	}

	public void deleteStud(int studID) {
		studentAddressService.deleteStudAddress(studID);
		studentRepo.deleteById(studID);
	}

	public Student updateStud(int studID, Student stud) {
		Student findByStudID = studentRepo.findById(studID).get();
		findByStudID.setStudID(stud.getStudID());
		findByStudID.setStudName(stud.getStudName());
		findByStudID.setSchoolName(stud.getSchoolName());
		findByStudID.setCity(stud.getCity());

		studentAddressService.updateStudAddress(studID, findByStudID);
		return studentRepo.save(findByStudID);
	}
}
