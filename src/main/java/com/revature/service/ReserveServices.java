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
	 * @throws  
	 */
	public Reserve reserveCan( Reserve reserve) throws SQLException {
		StockDAO sdao =new StockDAOImp();
		int availableStock = sdao.findavaiability();
		logger.info("Available"+availableStock + ",reserveCans:"+reserve.getReserveCans());
		int totalCanAfterReserve=0;
		 ReserveDAO rdao=new ReserveDAOImp();
				if (reserve.getReserveCans() <= availableStock) {
					rdao.addReserveCans(reserve);
					try {
						totalCanAfterReserve=availableStock - reserve.getReserveCans();
						sdao.updateStock(totalCanAfterReserve);
						reserve=rdao.selectReserve(reserve.getUserId());
					
					} catch (SQLException e) {
						e.printStackTrace();
						throw new SQLException(e.getMessage());
					}
			
			
		}
		else
		{
			reserve=null;
		}
				return reserve;
			
		}
	}