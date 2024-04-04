package com.emsproject.daos;

import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.Department;


// interface DepartmentDao methods for interacting with department entities in a database. See the Tim's code:


public interface DepartmentDao {
	
	int addDepartment(Department dep) throws SQLException;
	
	List<Department> viewAllDepartment();
	
	boolean updateDepartment() throws SQLException;
	
	boolean removeDepartment(int id) throws SQLException;
	
	int totalEmpCount(int id) throws SQLException;
	

}
