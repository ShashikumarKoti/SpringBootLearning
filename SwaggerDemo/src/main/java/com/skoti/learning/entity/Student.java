package com.skoti.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(description="All details about the student. ")
public class Student {

	@Id
	private int id;
	private String name;
	private String schoolName;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String schoolName) {
		super();
		this.id = id;
		this.name = name;
		this.schoolName = schoolName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
