package com.shopforhome.com.request;

import java.util.List;

public class CouponRequest {

	private String couponCode;
	
	private double couponPercentage;
	
	private List<String> userIds;
	
	public CouponRequest() {
		
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public double getCouponPercentage() {
		return couponPercentage;
	}

	public void setCouponPercentage(double couponPercentage) {
		this.couponPercentage = couponPercentage;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	

	
	
}
