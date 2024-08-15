package com.shopforhome.com.request;

public class CartItemUpdateRequest {

	private String cartItemId;
	
	private long newQuantity;
	
	public CartItemUpdateRequest()
	{
		
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public long getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(long newQuantity) {
		this.newQuantity = newQuantity;
	}
	
	
}
