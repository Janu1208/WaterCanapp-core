package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.Reserve;
import com.revature.model.User;

public interface ReserveDAO {
	  public void addReserveCans(Reserve reserve) throws SQLException;
		public void updateReserveCans(User user,int reserve_cans) throws SQLException;
		public Reserve selectReserve(int user_id) throws SQLException;
		   public void updateStatus(Reserve reserve,int order_cans) throws SQLException;

}