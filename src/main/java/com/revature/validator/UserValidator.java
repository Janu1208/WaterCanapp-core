package com.revature.validator;

import com.revature.exception.ValidatorException;
import com.revature.model.User;


public class UserValidator {
public static void validateBeforeRegistration(User user) throws ValidatorException {
		
		//1. Check name is not null
		String name = user.getName();
		if ( name == null || "".equals(name.trim())) {
			throw new ValidatorException("Invalid Name");
		}
	}
public static void passwordValidation(String userName, String password) throws Exception
{
   
        if (password.length() > 15 || password.length() < 8)
        {
                throw new ValidatorException("Password should be less than 15 and more than 8 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
                throw new ValidatorException("Password should contain atleast one upper case alphabet");
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
                throw new ValidatorException("Password should contain atleast one lower case alphabet");
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
                throw new ValidatorException("Password should contain atleast one number.");
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars ))
        {
                throw new ValidatorException("Password should contain atleast one special character");
        }
}
public static void validPhoneNumber(String phoneNumber) throws Exception
{
	if(phoneNumber.length() < 10 || phoneNumber.length() > 10 || phoneNumber.length()<0)
	{
		throw new ValidatorException("Invalid phone number");
		
	}
	 String upperCaseChars = "(.*[A-Z].*)";
     if (phoneNumber.matches(upperCaseChars ))
     {
             throw new ValidatorException("phone_number should not contain alphabet");
     }
     String lowerCaseChars = "(.*[a-z] .*)";
     if (phoneNumber.matches(lowerCaseChars ))
     {
             throw new ValidatorException("phone_number should not contain alphabet");
     }
     String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
     if (phoneNumber.matches(specialChars ))
     {
             throw new ValidatorException("phone number should notcontain special character");
     }
}
public static void validName(String name) throws Exception
{
	String numbers = "(.*[0-9].*)";
    if (name.matches(numbers ))
    {
            throw new ValidatorException("Name should not contains numeric values");
    }
    String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
    if (name.matches(specialChars ))
    {
            throw new ValidatorException("Name should not contains special character");
    }
}

}
