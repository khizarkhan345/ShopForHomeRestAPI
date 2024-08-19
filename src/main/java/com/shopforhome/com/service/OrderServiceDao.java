package com.shopforhome.com.service;

import java.util.List;

import com.shopforhome.com.entity.Order;
import com.shopforhome.com.request.OrderRequest;

public interface OrderServiceDao {

	public Order CreateOrder(OrderRequest orderRequest);
	
	public List<Order> getAllOrders();
	
	public Order getOrderById(String theId);
	
}
