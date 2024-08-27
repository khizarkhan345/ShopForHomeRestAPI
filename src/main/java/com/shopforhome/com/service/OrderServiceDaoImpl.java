package com.shopforhome.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.OrderItemRepository;
import com.shopforhome.com.dao.OrderRepository;
import com.shopforhome.com.entity.Coupon;
import com.shopforhome.com.entity.Order;
import com.shopforhome.com.entity.OrderItem;
import com.shopforhome.com.entity.Product;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.exception.UserServiceException;
import com.shopforhome.com.request.OrderItemRequest;
import com.shopforhome.com.request.OrderRequest;

@Service
public class OrderServiceDaoImpl implements OrderServiceDao {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private UserServiceDaoImpl userServiceImpl;
	
	@Autowired
	private ProductServiceDaoImpl productServiceImpl;
	
	
	@Override
	public Order CreateOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		try {
			
			Order order = new Order();
			
			if(order.getOrderId() == null) {
				order.setOrderId(UUID.randomUUID().toString());
			}
			
			order.setOrderDate(orderRequest.getOrderDate());
			order.setTotalPrice(orderRequest.getTotalPrice());
			
			User user = userServiceImpl.getUserById(orderRequest.getUserId());
			
			order.setUser(user);
			
			 List<OrderItem> orderItems = new ArrayList<>();

		        for (OrderItemRequest orderItemReq : orderRequest.getOrderItemRequest()) {
		            OrderItem orderItem = new OrderItem();
		            orderItem.setOrderItemId(UUID.randomUUID().toString());
		            orderItem.setQuantity(orderItemReq.getQuantity());
		            orderItem.setUnitPrice(orderItemReq.getUnitPrice());

		            Product product = productServiceImpl.getProductById(orderItemReq.getProductId());
		            orderItem.setProduct(product);
		            orderItem.setOrder(order);

		            orderItems.add(orderItem);
		        }

		        order.setOrderItems(orderItems);
		        Order savedOrder = orderRepo.save(order);

		        for (OrderItem orderItem : orderItems) {
		            orderItemRepo.save(orderItem);
		        }

		        return savedOrder;
		
	}catch(DataAccessException ex) {
		throw new UserServiceException("Failed to create new order", ex);
	}
		
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		
		try {
			
			return orderRepo.findAll();
			
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to fetch all orders", ex);
		}
		
	}

	@Override
	public Order getOrderById(String theId) {
		// TODO Auto-generated method stub
         try {
			
			return orderRepo.findById(theId).get();
			
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to fetch a single order by id", ex);
		}
	}

}
