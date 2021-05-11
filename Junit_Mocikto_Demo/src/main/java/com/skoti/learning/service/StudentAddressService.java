package com.skoti.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.Student;
import com.skoti.learning.entity.StudentAddress;
import com.skoti.learning.repo.StudentAddressRepo;

@Service
public class StudentAddressService {

	@Autowired
	private StudentAddressRepo studentAddressRepo;
	
	public StudentAddress saveStudAddr(Student stud) {
		StudentAddress studAddress = new StudentAddress();
		 studAddress.setId(stud.getStudID());
		 studAddress.setSchoolName(stud.getSchoolName());
		 studAddress.setCity(stud.getCity());
		 studentAddressRepo.save(studAddress);
		 return studAddress;
		 
	}
	
	public List<StudentAddress> getAllStudAddress() {
		System.out.println("Student Address service called");
		List<StudentAddress> findAllAddress = studentAddressRepo.findAll();
		System.out.println("All address: " + findAllAddress);
		return findAllAddress;
	}
	
	public void deleteStudAddress(int studID) {
		studentAddressRepo.deleteById(studID);
	}
	
	public StudentAddress updateStudAddress(int studID, Student stud) {
		StudentAddress findByStudID = studentAddressRepo.findById(studID).get();
		findByStudID.setSchoolName(stud.getSchoolName());
		findByStudID.setCity(stud.getCity());
		findByStudID.setId(stud.getStudID());
		return studentAddressRepo.save(findByStudID);
	}
	
}
