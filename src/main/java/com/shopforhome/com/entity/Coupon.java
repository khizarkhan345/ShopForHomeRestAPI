package com.shopforhome.com.entity;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="coupon_id")
	private UUID couponId;
	@Column(name="coupon_code")
	private String couponCode;
	@Column(name="percentage")
	private float couponPercentage;
	@Column(name="user_id")
	private UUID userId;
	
	@ManyToMany
	@JoinColumn(name="userId")
	private List<User> users;
	
	public Coupon() {
		
	}

	public Coupon(String couponCode, float couponPercentage, UUID userId) {
		super();
		this.couponCode = couponCode;
		this.couponPercentage = couponPercentage;
		this.userId = userId;
	}

	public UUID getCouponId() {
		return couponId;
	}

	public void setCouponId(UUID couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public float getCouponPercentage() {
		return couponPercentage;
	}

	public void setCouponPercentage(float couponPercentage) {
		this.couponPercentage = couponPercentage;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
	
	
}
