package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.model.User;


public class TestUserDAO {
	@Test
public  void testValidLogin()
{
	UserDAO udao=new UserDAOImp();
	String name="janshi";
	String password="janu";
	User user=null;
	
		try {
			user=udao.login( name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    assertNotNull(user);

}
@Test
public void testInValidLogin() {

	String email = "";
	String password = "";
	UserDAO userDAO = new UserDAOImp();
	User user = null;
	
		try {
			user = userDAO.login(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	assertNull(user);
}
}
