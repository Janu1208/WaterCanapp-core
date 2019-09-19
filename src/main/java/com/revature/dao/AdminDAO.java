package com.revature.dao;

import com.revature.model.Admin;

public interface AdminDAO {
	public Admin login(String name, String setPassword) throws Exception;
}
