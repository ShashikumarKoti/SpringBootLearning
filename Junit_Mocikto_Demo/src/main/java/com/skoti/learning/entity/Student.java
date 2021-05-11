package com.skoti.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	private int studID;
	private String studName;
	private String schoolName;
	private String city;
	
	
	public Student() {
		super();
	}

	public Student(int studID, String studName, String schoolName, String city) {
		super();
		this.studID = studID;
		this.studName = studName;
		this.schoolName = schoolName;
		this.city = city;
	}
	
	public int getStudID() {
		return studID;
	}
	public void setStudID(int studID) {
		this.studID = studID;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
