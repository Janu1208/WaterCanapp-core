package TestUserValidator;

import org.junit.Test;

import com.revature.validator.UserValidator;

public class TestPasswordValidation {

	@Test
	public void test() {
		String name = "ad";
        String password = "12345678Aa@";
        try {
            UserValidator.passwordValidation(name, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	

}
