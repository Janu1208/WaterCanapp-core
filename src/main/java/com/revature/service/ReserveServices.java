package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.ReserveDAO;
import com.revature.dao.ReserveDAOImp;
import com.revature.dao.StockDAO;
import com.revature.dao.StockDAOImp;
import com.revature.model.Reserve;
import com.revature.util.Logger;

public class ReserveServices {
	private static final Logger logger=Logger.getInstance();
	/**
	 * it will give facility for the user to reserve cans
	 * reserved cans should be greater than zero and it should not be null
	 * @param reserve
	 */
	public void reserveCan( Reserve reserve) {
		StockDAO sdao =new StockDAOImp();
		int availableStock = sdao.findavaiability();
		logger.info("Available"+availableStock + ",reserveCan:"+reserve.getReserveCans());
		int totalCanAfterReserve=0;
		if (reserve.getReserveCans() <= availableStock) {
			ReserveDAO rdao=new ReserveDAOImp();
			rdao.addReserveCans(reserve);
			totalCanAfterReserve=availableStock - reserve.getReserveCans();
			try {
				sdao.updateStock(totalCanAfterReserve);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
