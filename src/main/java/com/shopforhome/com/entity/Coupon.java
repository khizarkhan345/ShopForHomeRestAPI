package com.shopforhome.com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="coupons")
public class Coupon {

	@Id
	@Column(name="coupon_id")
	private String couponId;
	@Column(name="coupon_code")
	private String couponCode;
	@Column(name="percentage")
	private double couponPercentage;
	
	
	@ManyToMany(mappedBy="coupons")
	private List<User> users;
	
	public Coupon() {
		
	}

	public Coupon(String couponCode, float couponPercentage, UUID userId) {
		super();
		this.couponCode = couponCode;
		this.couponPercentage = couponPercentage;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
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

	public List<String> getUsersName(){
		
		List<String> userNames = new ArrayList<>();
		for(User user : users) {
			String name = user.getFirstName() + " " + user.getLastName();
			userNames.add(name);
		}
		
		return userNames;
	}
	
}
