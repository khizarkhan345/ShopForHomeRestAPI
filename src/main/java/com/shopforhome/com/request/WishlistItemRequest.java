package com.shopforhome.com.request;

public class WishlistItemRequest {

	public String wishlistId;
	
	public String productId;
	
	public WishlistItemRequest() {
		
	}

	public String getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
