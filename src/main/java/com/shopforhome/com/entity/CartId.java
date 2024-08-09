package com.shopforhome.com.entity;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;



public class CartId implements Serializable{

	private UUID userId;
	private UUID productId;
	
	public CartId() {
		
	}

	public CartId(UUID userId, UUID productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}



	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        CartId that = (CartId) o;
	        return userId == that.userId && Objects.equals(productId, that.productId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(userId, productId);
	    }
}
