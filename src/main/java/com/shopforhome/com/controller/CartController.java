package com.shopforhome.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.CartItems;
import com.shopforhome.com.request.CartItemRequest;
import com.shopforhome.com.service.CartServiceDaoImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartServiceDaoImpl cartServiceImpl;
	
	@GetMapping("/{id}")
	public Cart getCartsById(@PathVariable String id) {
		
		return cartServiceImpl.getCartById(id);
	}
	
	@GetMapping("/cartItems/{id}")
	public CartItems getCartItemsById(@PathVariable String id) {
		
		return cartServiceImpl.getCartItemsById(id);
	}
	
	@GetMapping("/cartItems/all")
	public List<CartItems> getAllCartItems(){
		return cartServiceImpl.getAllCartItems();
	}
	
	@PostMapping("/cartItems/save") 
	public CartItems saveCartItem(@RequestBody CartItemRequest cartItemRequest) {
		
		return cartServiceImpl.saveCartItems(cartItemRequest.getCart(), cartItemRequest.getProductId(), cartItemRequest.getQuantity());
	}
	

}
