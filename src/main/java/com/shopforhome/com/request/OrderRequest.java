package com.shopforhome.com.request;

import java.time.LocalDate;
import java.util.List;

public class OrderRequest {
	
	private LocalDate orderDate;
	
	private Double totalPrice;
	
	private String userId;
	
	private List<OrderItemRequest> orderItemRequest;
	
	
	public OrderRequest() {
		
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<OrderItemRequest> getOrderItemRequest() {
		return orderItemRequest;
	}


	public void setOrderItemRequest(List<OrderItemRequest> orderItemRequest) {
		this.orderItemRequest = orderItemRequest;
	}
	
	

}
