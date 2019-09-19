package util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.revature.util.ConnectionUtil;

public class ConnectionUtilTest {
	@Test
	public void testConnection() {
		Connection connection = ConnectionUtil.getConnection();
		assertNotNull(connection);
	}
}
