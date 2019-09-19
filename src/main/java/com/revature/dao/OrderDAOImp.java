package com.revature.dao;

import com.revature.model.Order;
import com.revature.model.User;

public interface OrderDAOImp {
	public void addOrder(Order order);
	public  void addReserveOrder(User user,int order_cans) throws Exception;
}
