package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.CartRepository;
import com.shopforhome.com.dao.CartItemsRepository;
import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.CartItems;
import com.shopforhome.com.entity.Product;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.exception.NotFoundException;
import com.shopforhome.com.exception.UserServiceException;

@Service
public class CartServiceDaoImpl implements CartServiceDao {
 
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CartItemsRepository cartItemsRepo;
	
	@Autowired
	private ProductServiceDaoImpl productServiceImpl;
	
	@Override
	public Cart getCartById(String theId) {
		// TODO Auto-generated method stub
		try {
			return cartRepo.findById(theId)
                    .orElseThrow(() -> new NotFoundException("Cart with ID " + theId + " not found"));
		}catch(DataAccessException ex) {
			throw new UserServiceException("Cart not found", ex);
		}
	}

	@Override
	public Cart createCart(User user) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setCartId(UUID.randomUUID().toString());
		
		return cartRepo.save(cart);
	}

	@Override
	public List<CartItems> getAllCartItems() {
		// TODO Auto-generated method stub
		return cartItemsRepo.findAll();
	}

	@Override
	public CartItems getCartItemsById(String theId) {
		// TODO Auto-generated method stub
		return cartItemsRepo.findById(theId).get();
	}

	@Override
	public CartItems saveCartItems(Cart cart, String productId, long quantity) {
		// TODO Auto-generated method stub
		Product product = productServiceImpl.getProductById(productId);
		
		CartItems cartItem = new CartItems();
		cartItem.setCartItemId(UUID.randomUUID().toString());
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		return cartItemsRepo.save(cartItem);
	}

}
