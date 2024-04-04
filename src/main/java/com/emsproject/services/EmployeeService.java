package com.emsproject.services;

import java.sql.Connection;

import com.emsproject.daos.EmployeeDaoImp;
import com.emsproject.entities.Employee;

public class EmployeeService {
	
	EmployeeDaoImp empDoaImp;
	
	public EmployeeService(Connection connection) {
		this.empDoaImp = new EmployeeDaoImp(connection);
	}
	
	
	public int addEmployee(Employee emp) {
		
		return this.empDoaImp.addEmployee(emp);
		
		
		
		
		
	}

}
