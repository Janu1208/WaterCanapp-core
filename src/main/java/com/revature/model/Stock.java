package com.revature.model;

import java.time.LocalDate;


public class Stock{
	
	private  Integer cansAvail;
	private LocalDate date;
	
	

	
	
	
	public LocalDate getDate() {
		return date;
	}

	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public  Integer getCansAvail() {
		return cansAvail;
	}
	
	public int setCans_avail(Integer cans_avail) {
		return this.cansAvail = cans_avail;
	}
	
	


}
