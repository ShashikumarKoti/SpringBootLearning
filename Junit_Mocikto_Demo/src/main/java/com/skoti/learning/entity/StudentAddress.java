package com.skoti.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUD_ADDRESS")
public class StudentAddress {

	@Id
	private int id;
	private String schoolName;
	private String city;
	
	public StudentAddress() {
		super();
	}

	public StudentAddress(int id, String schoolName, String city) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
