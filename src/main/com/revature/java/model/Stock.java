package com.revature.model;

import java.time.LocalDate;


public class Stock{
	
	private  Integer cans_avail;
	private LocalDate date;
	
	

	
	
	
	public LocalDate getDate() {
		return date;
	}

	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public  Integer getCans_avail() {
		return cans_avail;
	}
	
	public int setCans_avail(Integer cans_avail) {
		return this.cans_avail = cans_avail;
	}
	
	


}
