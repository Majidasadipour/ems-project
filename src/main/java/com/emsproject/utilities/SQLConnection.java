package com.emsproject.utilities;


//now connection to a MySQL database. don't write anything. see Tim's code. the same :)!!!


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	
	private static Connection connection = null;

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db", "root", "password");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
}
