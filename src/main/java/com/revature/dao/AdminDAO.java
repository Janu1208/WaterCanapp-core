package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.model.Admin;


public class AdminDAO implements AdminDAOImp {
	 public Admin login(String name, String password) throws Exception  {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			Admin admin = null;
			
			try {
				con = ConnectionUtil.getConnection();
				String sql = "select * from Admin where Name = ? and password = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2,password );
				rs = pst.executeQuery();
				if(rs.next()) {
					admin = new Admin();
				
					admin.setName(rs.getString("Name"));
					admin.setPassword(rs.getString("Password"));
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Unable to login",e);
			}
			
			return admin;
}
}
