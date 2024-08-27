package com.shopforhome.com.response;

import java.util.List;

import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.Coupon;
import com.shopforhome.com.entity.Wishlist;

public class LogInResponse {

	private String token;

    private long expiresIn;
    
    private String role;
    
    private String email;
    
    private String userId;
    
    private Wishlist wishlist;
    
    private Cart cart;
    
    private List<Coupon> coupon;
    
   

	public LogInResponse(String token, long expiresIn, String role, String email, String userId, Cart cart, List<Coupon> coupons, Wishlist wishlist) {
		super();
		this.token = token;
		this.expiresIn = expiresIn;
		this.role = role;
		this.email = email;
		this.userId = userId;
		this.cart = cart;
		this.coupon = coupons;
		this.wishlist = wishlist;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Coupon> getCoupon() {
		return coupon;
	}

	public void setCoupon(List<Coupon> coupon) {
		this.coupon = coupon;
	}
	
	
    
    
}
