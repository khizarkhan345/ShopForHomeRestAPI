package com.shopforhome.com.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopforhome.com.entity.Cart;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.entity.Wishlist;
import com.shopforhome.com.exception.NotFoundException;
import com.shopforhome.com.exception.UserServiceException;
import com.shopforhome.com.request.LogInRequest;
import com.shopforhome.com.dao.CartRepository;
import com.shopforhome.com.dao.UserRepository;
import com.shopforhome.com.dao.WishlistRepository;

@Service
public class UserServiceDaoImpl implements UserServiceDao{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartServiceDaoImpl cartServiceImpl;
	
	@Autowired 
	private WishlistServiceDaoImpl wishlistServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User getUserById(String theId) {
		// TODO Auto-generated method stub
		try {
            return userRepo.findById(theId)
                           .orElseThrow(() -> new NotFoundException("User with ID " + theId + " not found"));
        } catch (DataAccessException ex) {
            // Log the exception (using a logging framework) and throw a custom exception
            throw new UserServiceException("Failed to retrieve user with ID " + theId, ex);
        }
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		try {
			return userRepo.findAll();
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to retrieve users", ex);
		}
		
	}

	@Override
	public boolean deleteUserById(String theId) throws Exception{
		// TODO Auto-generated method stub
		  try {
	            User user = getUserById(theId);
	            userRepo.deleteById(theId);
	            return true;
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to delete user with ID " + theId, ex);
	        }
		
	}

	@Override
	public User updateUser(User user, String theId) throws Exception {
		// TODO Auto-generated method stub
		 try {
	            User existingUser = getUserById(theId);
	            existingUser.setFirstName(user.getFirstName());
	            existingUser.setLastName(user.getLastName());
	            existingUser.setEmail(user.getEmail());
	            existingUser.setPassword(user.getPassword());
	            return userRepo.save(existingUser);
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to update user with ID " + theId, ex);
	        }
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		//String myUserId;
		//String myCartId;
		//User savedUser;
		
		User newUser = new User();
		 try {
	          if (newUser.getUserId() == null) {
	               newUser.setUserId(UUID.randomUUID().toString());
	          }
	          
	          newUser.setFirstName(user.getFirstName());
	          newUser.setLastName(user.getLastName());
	          newUser.setEmail(user.getEmail());
	          newUser.setPassword(passwordEncoder.encode(user.getPassword()));
	          newUser.setRole(user.getRole());
	          
	          User savedUser = userRepo.save(newUser);
	          //System.out.println(user.getRole().toLowerCase());
	          if(user.getRole().toLowerCase().equals("customer")) {
	        	  System.out.println("Createing cart");
	        	  
	        	  Cart existingCart = savedUser.getCart();
	        	  
	        	  if(existingCart == null) {
	        		  Cart cart = cartServiceImpl.createCart(savedUser);
//		        	  cart.setUser(savedUser);
//		        	  cart.setCartId(UUID.randomUUID().toString());
		      
		        	  //cartRepo.save(cart);
		        	  
		        	  savedUser.setCart(cart);
	        	  }
	        	  
	        	  Wishlist existingWishlist = savedUser.getWishlist();
	        	  
	        	  if(existingWishlist == null) {
	        		  Wishlist wishlist = wishlistServiceImpl.saveWishlist(savedUser);
		        	  //wishlist.setUser(savedUser);
		        	  
		        	  //wishlistRepo.save(wishlist);
		        	  
		        	  savedUser.setWishlist(wishlist);
	        	  }
//	        	  
	        	  
	        	 // userRepo.save(savedUser);
	          }
	          
	
	           return savedUser;
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to save user", ex);
	      }
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
            User user = userRepo.findUserByEmail(email).get();
            return user;
        } catch (DataAccessException ex) {
            throw new UserServiceException("User not found ", ex);
        }
	}
	
	
	public User authenticate(LogInRequest input) {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        input.getEmail(),
	                        input.getPassword()
	                )
	        );

	        return userRepo.findUserByEmail(input.getEmail())
	                .orElseThrow();
	  }

}
