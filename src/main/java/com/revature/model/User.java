package com.revature.model;

public class User {
	
	
	private int id;
	private  String name;
	private String phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static int getCansAvail() {
		return cansAvail;
	}
	public static void setCansAvail(int cansAvail) {
		User.cansAvail = cansAvail;
	}
	public static int getReserveId() {
		return reserveId;
	}
	public static void setReserveId(int reserveId) {
		User.reserveId = reserveId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String password;
	private static int cansAvail;
	private static int reserveId;
	private String status;
	
	
	
	
}
