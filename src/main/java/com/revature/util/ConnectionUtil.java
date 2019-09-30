package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConnectionUtil {
	  private static final ConnectionUtil INSTANCE = new ConnectionUtil();
	    private static final Logger logger = Logger.getInstance();
	    private static final String driverClassName = "com.mysql.jdbc.Driver";
	    private static final String url = "jdbc:mysql://localhost:3306/watercane";
	    private static final String username = "root";
	    private static final String password = "root";
	    public static ConnectionUtil getInstance() {
	        return INSTANCE;
	    }
	    public static Connection getConnection() throws SQLException {
	        Connection con = null;
	        try {
	            Class.forName(driverClassName);
	            con = DriverManager.getConnection(url, username, password);
	            logger.info(con);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new SQLException("Unable to load the driver class");
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new SQLException("Unable to get DB Connection");
	        }
	        return con;
	    }
	    public static void close(Connection con, PreparedStatement pst) {
	        try {
	            if (pst != null)
	                pst.close();
	            if (con != null)
	                con.close();
	        } catch (SQLException e) {
	           // logger.debug(Messageconstants.CLOSE_CONNECTION);
	        	e.printStackTrace();
	        }
	    }
	    public static void closeRs(ResultSet rs) {
	        if (rs != null)
	            try {
	                rs.close();
	            } catch (SQLException e) {
	               // logger.debug(Messageconstants.CLOSE_CONNECTION);
	             	e.printStackTrace();
	            }
	    }
}
