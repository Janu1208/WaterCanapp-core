package com.revature.model;

public class Order {
	private int userId;

	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	private  Integer orderCans;
	@Override
	public String toString() {
		return "Order [orderCans=" + orderCans + "]";
	}


	public Integer getOrderCans() {
		return orderCans;
	}

	
	public void setOrderCans(Integer orderCans) {
		this.orderCans = orderCans;
	}

}
