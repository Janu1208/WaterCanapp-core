package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.model.Order;
import com.revature.model.Reserve;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.ErrorConstants;

public class OrderDAOImp implements OrderDAO
{
	public  void addOrder(Order order) throws SQLException
	{
	Connection con = ConnectionUtil.getConnection();
	String sql="insert into order_det(user_id,order_cans) values(?,?)";
	PreparedStatement pst = null;
	try {
		pst = con.prepareStatement(sql);
		pst.setInt(1, order.getUserId());
		pst.setInt(2, order.getOrderCans());

		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(ErrorConstants.ORDERCANS);
	}
	finally {
		ConnectionUtil.close(con, pst);
	}
	}
public void addReserveOrder(User user,int orderCans) throws Exception {
		
		Connection con =null;
		PreparedStatement pst = null;
		Reserve reserve=new Reserve();
		con = ConnectionUtil.getConnection();
		String sql = "insert into order_det(user_id,reserve_id,order_cans) values"
				+ "(?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.setInt(2, reserve.getReserveId());
			pst.setInt(3,orderCans);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(ErrorConstants.ORDERRESERVEDCANS,e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	
	
}