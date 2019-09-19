package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.OrderDAO;
import com.revature.dao.OrderDAOImp;
import com.revature.dao.StockDAO;
import com.revature.dao.StockDAOImp;
import com.revature.model.Order;

public class OrderService {
	public void orderCan( Order order) {
		StockDAOImp sdao =new StockDAO();
		int availableStock = sdao.findavaiability();
		System.out.println("Available:" + availableStock + ",orderCan:" + order.getOrderCans());
		int totalCanAfterOrder=0;
		if (order.getOrderCans() <= availableStock) {
			OrderDAOImp odao=new OrderDAO();
			odao.addOrder(order);
			totalCanAfterOrder=availableStock - order.getOrderCans();
			try {
				sdao.updateStock(totalCanAfterOrder);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}