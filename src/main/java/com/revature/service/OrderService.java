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
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws Exception 
	 * it will give facility for the user to add cans
	 * ordered cans should be greater than zero and it should not be null
	 * @param order
	 * @throws  
	 */
	public void orderCan( Order order) throws Exception {

		StockDAO sdao =new StockDAOImp();
		int availableStock = sdao.findavaiability();
		logger.info("Available"+availableStock + ",orderCans:"+order.getOrderCans());
		int totalCanAfterOrder=0;
		if (order.getOrderCans() <= availableStock ) {
			OrderDAO odao=new OrderDAOImp();
			odao.addOrder(order);
			totalCanAfterOrder=availableStock - order.getOrderCans();
		}
		else
		{
			throw new Exception("Invalid cans...please check available stock and re enter the value");
		}
			try {
				sdao.updateStock(totalCanAfterOrder);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} 
		
		
	}
}