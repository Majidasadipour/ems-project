package com.emsproject.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.emsproject.daos.DepartmentDaoImp;
import com.emsproject.entities.Department;

public class DepartmentService {
	
	DepartmentDaoImp depDaoImp;
	
	public DepartmentService (Connection connection) {
		
		this.depDaoImp = new DepartmentDaoImp(connection);
		
	}
	
	public int addDepartment(Department dep) {
		return this.depDaoImp.addDepartment(dep);
	}
	
	public int totalEmpCount(int id) {
		try {
			return depDaoImp.totalEmpCount(id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			return -1;
			
		}
	}

}