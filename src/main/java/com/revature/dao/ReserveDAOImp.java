package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Reserve;
import com.revature.model.Stock;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ReserveDAOImp implements ReserveDAO{
	
  public void addReserveCans(Reserve reserve) throws SQLException
  {
	  Connection con = ConnectionUtil.getConnection();
		String sql="insert into reserve(user_id,reserve_cans,status) values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, reserve.getUserId());
			pst.setInt(2,reserve.getReserveCans());
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
  
	public void updateReserveCans(User user,int reserveCans) throws SQLException
	{
		Connection con = ConnectionUtil.getConnection();
		String sql="update reserve set reserve_cans=? where user_id=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,user.getId());
			pst.setInt(2, reserveCans);
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
	}
	
	public Reserve selectReserve(int userId) throws SQLException
	{
		Connection con = ConnectionUtil.getConnection();
        String sql="select *from reserve  where user_id=? and status='Reserved', date =current_timestamp()";
        PreparedStatement pst = null;
        Reserve reserve=new Reserve();
        try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,userId);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
				reserve.setUserId(rs.getInt("userId"));
				reserve.setReserveId(rs.getInt("reserveId"));
				reserve.setReserveCans(rs.getInt("reserveCans"));
				reserve.setStatus(rs.getString("status"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        finally {
			ConnectionUtil.close(con, pst);
		}
		return reserve;
	}
	
   public void updateStatus(User user,int reserveCans) throws SQLException
   {
	   Connection con =null;
	    PreparedStatement pst = null;
	    Reserve reserve=new Reserve();
		con = ConnectionUtil.getConnection();
		String sql = "update reserve set status ='Ordered',reserve_cans=? where reserve_id= ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reserveCans);
			pst.setInt(2,reserve.getReserveId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}
   
   public User findById(int id) throws SQLException {
		
		Connection con =null;
		PreparedStatement pst = null;
		Reserve reserve=new Reserve();
		Stock stock=new Stock();
	    con = ConnectionUtil.getConnection();
		String sql = "select * from reserve where User_id=? and status='Order Pending' ";
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    user = new User();
				reserve.setReserveId(rs.getInt("reserveId"));
				user.setId(rs.getInt("userId"));
				stock.setCansAvail(rs.getInt("reserveCans"));
			
				
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