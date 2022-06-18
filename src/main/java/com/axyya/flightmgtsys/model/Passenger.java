package com.axyya.flightmgtsys.model;

import javax.persistence.Embeddable;

@Embeddable
public class Passenger {
	
	private String fullname;
	private int age;
	private Gender gender;
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String fullname, int age, Gender gender) {
		super();
		this.fullname = fullname;
		this.age = age;
		this.gender=gender;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Passenger [fullname=" + fullname + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
