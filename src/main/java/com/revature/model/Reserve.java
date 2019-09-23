package com.revature.model;

public class Reserve {
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private  Integer ReserveCans;
    public Integer getReserveCans() {
		return ReserveCans;
	}
	public void setReserveCans(Integer reserveCans) {
		ReserveCans = reserveCans;
	}
	private String status;

}
