package com.emsproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.Employee;

public class EmployeeDaoImp implements EmployeeDao {
	
	private Connection connection;
	
	public EmployeeDaoImp (Connection connectionInput) {
		this.connection = connectionInput;
	}

	@Override
	public int addEmployee(Employee emp) {

		int returnValue=0;
		
		try {
			
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into employees values(?,?,?,?)");
			stmt.setInt(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setString(3, emp.getPosition());
			stmt.setInt(4, emp.getDepartmentId());
			
			returnValue = stmt.executeUpdate();
			
			if(returnValue!=0) {
				System.out.println("\n *** Employee Added Successfully *** \n \n");
				System.out.println("Returning Back to Menu... \n");
			}
				
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return returnValue;
	}

	
	@Override
	public List<Employee> viewAllEmployee() {
		
		
		return null;
	}

	@Override
	public boolean updateEmployee() throws SQLException {
		
		
		return false;
	}

	@Override
	public boolean removeEmployee(int id) throws SQLException {
		

		return false;
	}

	 

}
