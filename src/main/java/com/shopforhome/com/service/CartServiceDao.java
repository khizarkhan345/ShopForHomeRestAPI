package com.shopforhome.com.service;

import java.util.List;

import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.CartItems;
import com.shopforhome.com.entity.User;

public interface CartServiceDao {

	public Cart getCartById(String theId);
	
	public Cart createCart(User user);
	
	public List<CartItems> getAllCartItems();
	
	public CartItems getCartItemsById(String theId);
	
	public List<CartItems> getCartItemsByCartId(String theId);
	
	public boolean  removeItemsFromCart(String theId);
	
	public CartItems  addItemToCart(Cart cart, String productId, long quantity);
	
	public CartItems updateCartItem(String cartItemId, long newQuantity);
	
	//public Cart editCart(Cart cart, )
}
