package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.ReserveDAO;
import com.revature.dao.ReserveDAOImp;
import com.revature.dao.StockDAO;
import com.revature.dao.StockDAOImp;
import com.revature.model.Reserve;

public class ReserveServices {
	public void reserveCan( Reserve reserve) {
		StockDAO sdao =new StockDAOImp();
		int availableStock = sdao.findavaiability();
		System.out.println("Available:" + availableStock + ",ReserveCan:" + reserve.getReserveCans());
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
