package com.revature.dao;

import com.revature.model.User;

public interface ReserveDAO {
	  public void addReserveCans(User user,int reserve_cans);
		public void updateReserveCans(User user,int reserve_cans);
		public User selectReserve(int reserve_id);
		   public void updateStatus(User user,int order_cans);

}
