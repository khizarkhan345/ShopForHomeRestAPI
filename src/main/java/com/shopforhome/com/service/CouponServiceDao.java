package com.shopforhome.com.service;

import java.util.List;

import com.shopforhome.com.entity.Coupon;
import com.shopforhome.com.request.CouponRequest;

public interface CouponServiceDao {

	public List<Coupon> getAllCoupons();
	
	public Coupon CreateCoupon(CouponRequest couponRequest);
	
	public boolean DeleteCoupon(String theId);
	
}
