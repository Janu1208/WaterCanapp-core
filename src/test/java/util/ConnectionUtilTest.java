package util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.util.ConnectionUtil;

public class ConnectionUtilTest {
	@Test
	public void testConnection() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		assertNotNull(connection);
	}
}
