package com.revature.model;

import java.time.LocalDate;

public class Reserve {
	private int userId;
	private static int reserveId;
	private LocalDate date;

	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		Reserve.reserveId = reserveId;
	}
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
		this.reserveCans = reserveCans;
	}
	private String status;

}
