package com.emsproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.emsproject.entities.User;

//UserDaoImp class implements the UserDao interface. see the UserDao.
public class UserDaoImp implements UserDao{

	private Connection connection;
	
	//The class has a constructor that takes a Connection object as a parameter and initializes the connection variable with it.
	public  UserDaoImp(Connection connectionInput) {
		this.connection = connectionInput;
	}
	
	
    @Override
    public User getUserByUsername(String username) {
    	//This method retrieves a user from the database based on the provided username.
    	//It prepares a SQL query to select a user with the specified username.
    	
        String query = "select * from users where username = ?";
        
        //execute query, retrieves result set. if a user found, create a new User object with retrieved username and password and returns it.

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String retrievedUsername = resultSet.getString("username");
                    String retrievedPassword = resultSet.getString("password");

          
                    return new User(retrievedUsername, retrievedPassword);
                }
            }
        } catch (SQLException e) {
        	//In case of any SQL exception, print the stacktrace and returns null.
            e.printStackTrace();
        }
        return null;
    }
    
    //This method is not implemented. sorry Tim, didnt have time. maybe later

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

    //This method is not implemented. sorry Tim, didnt have time. maybe later
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

    //This method is not implemented. sorry Tim, didnt have time. maybe later
	@Override
	public int addUser(User user) {
		int returnValue=0;
	
		
		try {
			
			PreparedStatement stmt;
			stmt = connection.prepareStatement("insert into users values(0,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
		
			
			returnValue = stmt.executeUpdate();
			
			if(returnValue!=0) {
				System.out.println("\n *** User Added Successfully *** \n \n");
				System.out.println("Returning Back to Menu... \n");
			}
				
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return returnValue;
	
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

}
