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
		
		try {
			Cart cart = new Cart();
			cart.setUser(user);
			cart.setCartId(UUID.randomUUID().toString());
			
			return cartRepo.save(cart);
			
		}catch (DataAccessException ex) {
            throw new UserServiceException("Failed to create cart", ex);
         }
		
	}

	@Override
	public List<CartItems> getAllCartItems() {
		// TODO Auto-generated method stub
		try {
			return cartItemsRepo.findAll();
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to retrieve Cart Items", ex);
		}
		
		
	}

	@Override
	public CartItems getCartItemsById(String theId) {
		// TODO Auto-generated method stub
		try {
            return cartItemsRepo.findById(theId)
                           .orElseThrow(() -> new NotFoundException("CartItem with id " + theId + " not found"));
        } catch (DataAccessException ex) {
            // Log the exception (using a logging framework) and throw a custom exception
            throw new UserServiceException("Failed to retrieve cartItem with id " + theId, ex);
        }
		
	}

	@Override
	public CartItems addItemToCart(Cart cart, String productId, long quantity) {
		// TODO Auto-generated method stub
		
		try {
			Product product = productServiceImpl.getProductById(productId);
			
			CartItems cartItem = new CartItems();
			cartItem.setCartItemId(UUID.randomUUID().toString());
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(quantity);
			return cartItemsRepo.save(cartItem);
			
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to add Item to cart", ex);
		}
		
	}

	@Override
	public boolean removeItemsFromCart(String theId) {
		// TODO Auto-generated method stub
		 try {
	            CartItems cartItems = getCartItemsById(theId);
	            cartItemsRepo.deleteById(theId);
	            return true;
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to delete user with ID " + theId, ex);
	        }
		
	}

	@Override
	public CartItems updateCartItem(String cartItemId, long newQuantity) {
		// TODO Auto-generated method stub
		try {
			
			CartItems cartItems = getCartItemsById(cartItemId);
			
			cartItems.setQuantity(newQuantity);
			
			return cartItemsRepo.save(cartItems);
			
		} catch (DataAccessException ex) {
            throw new UserServiceException("Failed to update CartItem with id " + cartItemId, ex);
        }
	}

	@Override
	public List<CartItems> getCartItemsByCartId(String theId) {
		// TODO Auto-generated method stub
		try {
            return cartItemsRepo.getCartItemsByCartId(theId);
        } catch (DataAccessException ex) {
            // Log the exception (using a logging framework) and throw a custom exception
            throw new UserServiceException("Failed to retrieve cartItems with id " + theId, ex);
        }
	}

}
