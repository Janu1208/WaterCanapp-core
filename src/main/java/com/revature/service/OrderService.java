package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.OrderDAO;
import com.revature.dao.OrderDAOImp;
import com.revature.dao.StockDAO;
import com.revature.dao.StockDAOImp;
import com.revature.model.Order;
import com.revature.util.Logger;

public class OrderService {
	private static final Logger logger=Logger.getInstance();

	/**
	 * it will give facility for the user to add cans
	 * ordered cans should be greater than zero and it should not be null
	 * @param order
	 * @throws  
	 */
	public void orderCan( Order order) throws SQLException {

		StockDAO sdao =new StockDAOImp();
		int availableStock = sdao.findavaiability();
		logger.info("Available"+availableStock + ",orderCans:"+order.getOrderCans());
		int totalCanAfterOrder=0;
		if (order.getOrderCans() <= availableStock) {
			OrderDAO odao=new OrderDAOImp();
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