package com.revature.service;

import java.sql.SQLException;
import java.util.List;


import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImp;
import com.revature.dao.StockDAO;
import com.revature.dao.StockDAOImp;
import com.revature.exception.DBException;
import com.revature.model.Admin;
import com.revature.model.Stock;
import com.revature.util.ErrorConstants;

public class AdminServices {
	AdminDAO adao=new AdminDAOImp();
/**
 * Enter registered name and password
 * values should not be null
 * @param name
 * @param password
 * @return
 * if u try to login with name and password that is not registered you will get invalid login
 * @throws Exception
 */
	public Admin login(String Name,String Password) throws Exception
	{
		Admin admin=null;
	     try {
	    	 admin=adao.login(Name,Password);
	    	 if(admin==null)
	    	 {
	    		 throw new Exception(ErrorConstants.LOGIN);

	    	 }
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e);

		}
		return admin;
		
	}
	/**
	 * to show the updated stock
	 * @return
	 * @throws Exception
	 */
	public List<Stock> stockView() throws Exception {

		StockDAO dao = new StockDAOImp();
		List<Stock> list = null;
		try {
			list = dao.viewStock();
		} catch (DBException e) {

			e.printStackTrace();
		}

		return list;
	}
	/**
	 * addCans should only be in integer value
	 * value should not be null
	 * value should be greater than zero
	 * @param addCans
	 * @throws SQLException 
	 */
	public void setAvailableCans(int addCans) throws SQLException 
	{
		int update;
		StockDAO dao = new StockDAOImp();
        update = dao.findavaiability();
    int updateCans=addCans+update;
   try {
	dao.updateStock(updateCans);
	
} catch (SQLException e) {
	e.printStackTrace();
}
				
	}
}