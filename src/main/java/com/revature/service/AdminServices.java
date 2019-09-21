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

public class AdminServices {
	AdminDAO adao=new AdminDAOImp();

	public Admin login(String name,String password) throws Exception
	{
		Admin admin=null;
	     try {
	    	 admin=adao.login(name,password);
	    	 if(admin==null)
	    	 {
	    		 throw new Exception("Invalid Login");

	    	 }
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e);

		}
		return admin;
		
	}
	public List<Stock> stockView() throws Exception {

		StockDAO dao = new StockDAOImp();
		List<Stock> list = null;
		try {
			list = dao.viewStock();
		} catch (DBException e) {

			e.printStackTrace();
		}

		System.out.println();
		return list;
	}
	public void setAvailableCans(int addCans) 
	{
		int update;
		StockDAO dao = new StockDAOImp();
        update = dao.findavaiability();
    int updateCans=addCans+update;
   try {
	dao.updateStock(updateCans);
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		

		
	}
}
