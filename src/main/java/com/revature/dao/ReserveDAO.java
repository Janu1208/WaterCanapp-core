package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ReserveDAO implements ReserveDAOImp{
	
  public void addReserveCans(User user,int reserve_cans)
  {
	  Connection con = ConnectionUtil.getConnection();
		String sql="insert into reserve(user_id,reserve_cans,status) values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.setInt(2,reserve_cans);
			pst.setString(3,"Reserved");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to reserve");
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
  }
  
	public void updateReserveCans(User user,int reserve_cans)
	{
		Connection con = ConnectionUtil.getConnection();
		String sql="update reserve set reserve_cans=? where user_id=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,user.getId());
			pst.setInt(2, reserve_cans);
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
	}
	
	public User selectReserve(int reserve_id)
	{
		Connection con = ConnectionUtil.getConnection();
        String sql="select *from reserve  where reserve_id=? and status='Reserved'";
        PreparedStatement pst = null;
        User user=null;
        try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reserve_id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    user = new User();
				user.setId(rs.getInt("user_id"));
				user.setReserve_id(rs.getInt("reserve_id"));
				user.setCans_avail(rs.getInt("reserve_cans"));
				user.setStatus(rs.getString("status"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        finally {
			ConnectionUtil.close(con, pst);
		}
		return user;
	}
	
   public void updateStatus(User user,int reserve_cans)
   {
	   Connection con =null;
	    PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "update reserve set status ='Ordered',reserve_cans=? where reserve_id= ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reserve_cans);
			pst.setInt(2,User.getReserve_id());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}
   
   public User findById(int id) {
		
		Connection con =null;
		PreparedStatement pst = null;
	    con = ConnectionUtil.getConnection();
		String sql = "select * from reserve where User_id=? and status='Order Pending' ";
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    user = new User();
				user.setReserve_id(rs.getInt("reserve_id"));
				user.setName(rs.getString("User_name"));
				user.setId(rs.getInt("user_id"));
				user.setCans_avail(rs.getInt("reserve_cans"));
			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return user;
	}


}
