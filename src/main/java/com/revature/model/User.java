package com.revature.model;

public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone_number=" + phone_number + ", password=" + password
				+ ", status=" + status + "]";
	}
	private int id;
	private  String name;
	private String phone_number;
	private String password;
	private static int cans_avail;
	private static int reserve_id;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}


	
	public void setStatus(String status) {
		this.status = status;
	}


	public static int getReserve_id() {
		return reserve_id;
	}

	
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}

	
	
	
	

	
	
	
	
	public static Integer getCans_avail() {
		return cans_avail;
	}
	
	public void setCans_avail(int cans_avail) {
		this.cans_avail = cans_avail;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public  Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
