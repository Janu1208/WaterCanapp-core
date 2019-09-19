package TestUserValidator;


import org.junit.Test;

import com.revature.validator.UserValidator;


public class TestNameValidation {

	@Test
	public void test() {
		String name = "n789";
		try {
			UserValidator.validName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
