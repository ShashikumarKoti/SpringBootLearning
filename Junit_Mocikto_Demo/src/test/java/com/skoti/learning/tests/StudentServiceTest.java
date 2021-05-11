package com.skoti.learning.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.skoti.learning.entity.Student;
import com.skoti.learning.entity.StudentAddress;
import com.skoti.learning.repo.StudentRepo;
import com.skoti.learning.service.StudentAddressService;
import com.skoti.learning.service.StudentService;

@SpringBootTest

public class StudentServiceTest {

	@InjectMocks
	private StudentService studentService;
	
	@Mock
	private StudentAddressService studentAddressService;
	
	@Mock
	private StudentRepo studentRepo;
	
	@Before(value = "")
	public void executeBefore() {
		System.out.println("Before method executed");
	}
	
	@After(value = "")
	public void executeAfter() {
		System.out.println("After method executed");
	}
	
	@Test
	public void test_getAllStuds( ) {
		List<Student> studList = new ArrayList<>();
		List<StudentAddress> studAddrList = new ArrayList<>();
		Student stud = new Student(1, "test_stud", "test_schoolName", "test_city");
		studList.add(stud);
		
		StudentAddress studAddr = new StudentAddress(1, "test_schoolNam", "test_city");
		studAddrList.add(studAddr);
		
		Mockito.when(studentAddressService.getAllStudAddress()).thenReturn(studAddrList);
		Mockito.when(studentRepo.findAll()).thenReturn(studList);
		
		List<Student> allStuds = studentService.getAllStuds();
		
		assertEquals(1, allStuds.size());
	}
}
