package com.shopforhome.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.CartItems;
import com.shopforhome.com.request.CartItemRequest;
import com.shopforhome.com.request.CartItemUpdateRequest;
import com.shopforhome.com.service.CartServiceDaoImpl;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {
	
	@Autowired
	private CartServiceDaoImpl cartServiceImpl;
	
	@GetMapping("/{id}")
	public Cart getCartsById(@PathVariable String id) {
		
		return cartServiceImpl.getCartById(id);
	}
	
	@GetMapping("/cartItem/{id}")
	public CartItems getCartItemsById(@PathVariable String id) {
		
		return cartServiceImpl.getCartItemsById(id);
	}
	
	@GetMapping("/cartItems/{cartId}")
	public List<CartItems> getAllCartItemsByCartId(@PathVariable String cartId) {
		return cartServiceImpl.getCartItemsByCartId(cartId);
	}
	
	@GetMapping("/cartItems/all")
	public List<CartItems> getAllCartItems(){
		return cartServiceImpl.getAllCartItems();
	}
	
	@PostMapping("/cartItem/save") 
	public CartItems addItemToCart(@RequestBody CartItemRequest cartItemRequest) {
		
		return cartServiceImpl.addItemToCart(cartItemRequest.getCart(), cartItemRequest.getProductId(), cartItemRequest.getQuantity());
	}
	
    @DeleteMapping("/cartItem/{id}")
	public boolean removeItemFromCart(@PathVariable String id) {
		return cartServiceImpl.removeItemsFromCart(id);
	}
    
    @PutMapping("/cartItem/{id}")
    public CartItems updateCartItemQuantity(@RequestBody CartItemUpdateRequest cartItemUpdateRequest, @PathVariable String id) {
    	return cartServiceImpl.updateCartItem(id, cartItemUpdateRequest.getNewQuantity());
    }
	
}
