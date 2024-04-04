package com.emsproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.Department;

// implementation of the DepartmentDao interface in the DepartmentDaoImp class. 
public class DepartmentDaoImp implements DepartmentDao {
	private Connection connection;
	
	public DepartmentDaoImp (Connection connectionInput) {
		this.connection = connectionInput;
	}


	@Override
	public int addDepartment(Department dep) {
		// This method adds a new department to the database (check database later).
		// take a Department object as a parameter.
		
		int returnValue=0;
		
		try {
			//prepares sql INSERT statement and set values for department ID, name, and total employee count.
			
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into departments values(?,?,?)");
			stmt.setInt(1, dep.getId());
			stmt.setString(2, dep.getName());
			stmt.setInt(3, dep.getTotalEmp());

			
			returnValue = stmt.executeUpdate();
			
			if(returnValue!=0) {
				System.out.println("\n *** Department Added Successfully *** \n \n");
				System.out.println("Returning Back to Menu... \n");
			}
				
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return returnValue;
	}

	//This method is not implemented. have no time. maybe late!!! sorry Tim.
	@Override
	public List<Department> viewAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	//This method is not implemented. have no time. maybe late!!! sorry Tim.
	@Override
	public boolean updateDepartment() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	//This method is not implemented. have no time. maybe late!!! sorry Tim.
	@Override
	public boolean removeDepartment(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	// calculate total number of employees in a department based on the provided department ID.
	@Override
	public int totalEmpCount(int id) throws SQLException {
		int totalEmpCount = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//use sql SELECT statement to count the number of employees with department ID.
			
			stmt = connection.prepareStatement("select count(*) as totalEmp from employees where departmentId= ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				totalEmpCount = rs.getInt("totalEmp");
			} 
			//update the totalEmp of the department with the calculated total employee count using an sql UPDATE.
			// we had it before, see the Tim's code.

			PreparedStatement updateStmt = connection.prepareStatement("update departments set totalEmp = ? where id = ?");
	        updateStmt.setInt(1, totalEmpCount);
	        updateStmt.setInt(2, id);
	        updateStmt.executeUpdate();
	        
		} finally {
			//Inside the finally block, it checks if the ResultSet is not null. 
			//If it's not null, it calls the close() method on it to release the associated resources.

			if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
			
			return totalEmpCount;
			
	}

}
