package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionUtil {
	  private static final ConnectionUtil INSTANCE = new ConnectionUtil();
	    private static final Logger logger = Logger.getInstance();
	    private static final String driverClassName = "com.mysql.cj.jdbc.Driver";
	    private static final String url = "jdbc:mysql://trainingdb.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/jhansi_db";
	    private static final String username = "jhansi";
	    private static final String password = "jhansi";
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
