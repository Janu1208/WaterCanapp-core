package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Stock;

public interface StockDAOImp {
	public  int findavaiability();
	public void  availStock(int cans) throws Exception;
	public void updateStock(int cans) throws SQLException;
	public List<Stock> viewStock() throws Exception;
   
}
