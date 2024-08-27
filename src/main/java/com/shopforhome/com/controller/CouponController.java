package com.shopforhome.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.Coupon;
import com.shopforhome.com.request.CouponRequest;
import com.shopforhome.com.service.CouponServiceDaoImpl;

@RestController
@RequestMapping("/api/coupon")
@CrossOrigin
public class CouponController {
	
	@Autowired
	private CouponServiceDaoImpl couponServiceImpl;
	
	@GetMapping("/all")
	public List<Coupon> getAllCoupons(){
		return couponServiceImpl.getAllCoupons();
	}
	
	@PostMapping("/save")
	public Coupon createCoupon(@RequestBody CouponRequest couponRequest) {
		System.out.println(couponRequest);
		return couponServiceImpl.CreateCoupon(couponRequest);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCoupon(@PathVariable String id) {
		return couponServiceImpl.DeleteCoupon(id);
	}

}
