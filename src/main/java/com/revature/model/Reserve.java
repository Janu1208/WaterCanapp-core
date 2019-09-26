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
	private  Integer reserveCans;
    public Integer getReserveCans() {
		return reserveCans;
	}
	public void setReserveCans(Integer reserveCans) {
		reserveCans = reserveCans;
	}
	private String status;

}
