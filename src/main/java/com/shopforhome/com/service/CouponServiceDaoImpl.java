package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.CouponRepository;
import com.shopforhome.com.entity.Coupon;
import com.shopforhome.com.entity.Product;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.exception.UserServiceException;
import com.shopforhome.com.request.CouponRequest;

@Service
public class CouponServiceDaoImpl implements CouponServiceDao{

	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private UserServiceDaoImpl userServiceImpl;
	
	@Override
	public Coupon CreateCoupon(CouponRequest couponRequest) {
		// TODO Auto-generated method stub
		try {
			
			    
				
				
				Coupon coupon = new Coupon();
				
				
				coupon.setCouponId(UUID.randomUUID().toString());
				coupon.setCouponCode(couponRequest.getCouponCode());
				coupon.setCouponPercentage(couponRequest.getCouponPercentage());
				
				for(String userId: couponRequest.getUserIds()) {
					User user = userServiceImpl.getUserById(userId);
					user.getCoupons().add(coupon);
				}
				
				
				return couponRepo.save(coupon);
			
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to save the product", ex);
		}
		
		
	}

	@Override
	public boolean DeleteCoupon(String theId) {
		// TODO Auto-generated method stub
		try {
            //Coupon coupon = couponRepo.findById(theId).get();
            couponRepo.deleteById(theId);
            return true;
        } catch (DataAccessException ex) {
            throw new UserServiceException("Failed to delete Coupon with ID " + theId, ex);
        }
	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return couponRepo.findAll();
	}

}
