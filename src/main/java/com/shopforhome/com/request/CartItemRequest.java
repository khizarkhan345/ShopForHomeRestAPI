package com.shopforhome.com.request;

import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.User;

public class CartItemRequest {

	private Cart cart;
	
	private String productId;
	
	private long quantity;
	
	public CartItemRequest() {
		
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

    
	
}
