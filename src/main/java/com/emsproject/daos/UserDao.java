package com.emsproject.daos;

import java.util.List;

import com.emsproject.entities.User;

// The UserDao interface defines the contract for managing user data in the EMS (Employee Management System) project.

public interface UserDao {
	
	    User getUserById(int id);
	    User getUserByUsername(String username);
	    List<User> getAllUsers();
	    int addUser(User user);
	    void updateUser(User user);
	    void deleteUser(int id);
	}



