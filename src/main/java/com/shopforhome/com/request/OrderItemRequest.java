package com.shopforhome.com.request;

public class OrderItemRequest {
	
	private long quantity;
	
	private double unitPrice;
	
	private String productId;
	
	public OrderItemRequest() {
		
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	

}
