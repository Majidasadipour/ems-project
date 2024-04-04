package com.emsproject.daos;

import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.Employee;

public interface EmployeeDao {
	
	int addEmployee(Employee emp) throws SQLException; 
	
	List<Employee> viewAllEmployee();
	
	boolean updateEmployee() throws SQLException;
	
	boolean removeEmployee(int id) throws SQLException;
	

	

}
