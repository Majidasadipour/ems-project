package com.emsproject.entities;


// let's do department class. three private instance variables. see the table in sql

public class Department {
	
	private int id;
	private String name;
	private int totalEmp;
	
	// instance variable are private, so write public getter and setter methods. with generate.

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
	public int getTotalEmp() {
		return totalEmp;
	}
	public void updateTotalEmp(int totalEmp) {
		this.totalEmp = totalEmp;
	}

}
