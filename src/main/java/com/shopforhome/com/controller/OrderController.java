package com.shopforhome.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.Order;
import com.shopforhome.com.request.OrderRequest;
import com.shopforhome.com.service.OrderServiceDaoImpl;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderServiceDaoImpl orderServiceImpl;
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable String id) {
		
		return orderServiceImpl.getOrderById(id);
	}
	
	@GetMapping("/all")
	public List<Order> getAllOrders() {
		
		return orderServiceImpl.getAllOrders();
	}
	
	@PostMapping("/save")
	public Order CreateNewOrder(@RequestBody OrderRequest orderRequest) {
		
		return orderServiceImpl.CreateOrder(orderRequest);
	}

}
