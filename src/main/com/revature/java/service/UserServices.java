package com.revature.service;


import com.google.protobuf.ServiceException;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.exception.DBException;
import com.revature.model.User;
import com.revature.validator.UserValidator;

import sun.security.validator.ValidatorException;

public class UserServices {
	UserDAOImp udao=new UserDAO();
	
public void register(User user) throws Exception
{
	try {
		UserValidator.validateBeforeRegistration(user);
		UserValidator.validName(user.getName());
		UserValidator.passwordValidation(user.getName(),user.getPassword());
		UserValidator.validPhone_number(user.getPhone_number());
		try {
			udao.register(user);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	} catch (ValidatorException e1) {
		e1.printStackTrace();
		throw new ServiceException(e1.getMessage());
	}
	
}
public User login(String phone_number,String password) throws Exception 
{
	User user=null;
	
     try {
    	 user=udao.login(phone_number,password);
	} catch (DBException e) {
		e.printStackTrace();
	}
	return user ;
	
}

}
