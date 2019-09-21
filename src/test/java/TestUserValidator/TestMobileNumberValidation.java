package TestUserValidator;



import org.junit.Test;

import com.revature.validator.UserValidator;


public class TestMobileNumberValidation {

	@Test
	public void test() {
		String phone_number="755012299698";
		try {
			UserValidator.validPhone_number(phone_number);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
