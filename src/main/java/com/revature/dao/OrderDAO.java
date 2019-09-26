package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.Order;
import com.revature.model.User;

public interface OrderDAO {
	public void addOrder(Order order) throws SQLException;
	public  void addReserveOrder(User user,int order_cans) throws Exception;
}