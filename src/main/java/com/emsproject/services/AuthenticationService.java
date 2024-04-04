package com.emsproject.services;

import java.sql.Connection;

import com.emsproject.daos.UserDao;
import com.emsproject.daos.UserDaoImp;
import com.emsproject.entities.User;

public class AuthenticationService {
	 private UserDao userDao;
	 
	 
	 public AuthenticationService(Connection connection) {
	        this.userDao = new UserDaoImp (connection);
	    }
	 
	 public boolean login(String username, String password) {
	        User user = userDao.getUserByUsername(username);
	        if (user != null && user.getPassword().equals(password)) {
	           
	            return true;
	        }
	        return false;
	    }

	 public void logout() {
	       
	    }
	}


