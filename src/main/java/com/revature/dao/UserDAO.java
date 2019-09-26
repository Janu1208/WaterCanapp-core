package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.User;

public interface UserDAO {
	 public void register(User user) throws Exception; 
	 public User login(String name, String setPassword) throws Exception; 
	 public  User getUserID(String name) throws SQLException;


}