package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Stock;

public interface StockDAO {
	public  int findavaiability() throws SQLException;
	public void  availStock(int cans) throws Exception;
	public void updateStock(int cans) throws SQLException;
	public List<Stock> viewStock() throws Exception;
   
}