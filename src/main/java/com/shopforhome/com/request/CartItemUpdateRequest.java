package com.shopforhome.com.request;

public class CartItemUpdateRequest {


	
	private long newQuantity;
	
	public CartItemUpdateRequest()
	{
		
	}

	public long getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(long newQuantity) {
		this.newQuantity = newQuantity;
	}
	
	
}
