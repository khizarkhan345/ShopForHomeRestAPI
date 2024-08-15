package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.WishlistRepository;
import com.shopforhome.com.entity.Product;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.entity.Wishlist;
import com.shopforhome.com.exception.UserServiceException;

@Service
public class WishlistServiceDaoImpl implements WishlistServiceDao {

	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Autowired
	private ProductServiceDaoImpl productServiceImpl;
	
	@Override
	public Wishlist saveWishlist(User user) {
		// TODO Auto-generated method stub
		
		try {
			Wishlist wishlist = new Wishlist();
			wishlist.setUser(user);
			wishlist.setWishlistId(UUID.randomUUID().toString());
			return wishlistRepo.save(wishlist);
			
		}catch (DataAccessException ex) {
            throw new UserServiceException("Failed to fetch Wishlist Products ", ex);
        }
		
	}
	@Override
	public List<Wishlist> getAllWishListProducts() {
		// TODO Auto-generated method stub
		try {
			return wishlistRepo.findAll();
		}catch (DataAccessException ex) {
            throw new UserServiceException("Failed to fetch Wishlist Products ", ex);
        }
		
	}
	
	@Override
	public Wishlist addProductToWishlist(String wishlistId, String productId) {
		// TODO Auto-generated method stub
		
		try {
			Wishlist wishlist = wishlistRepo.findById(wishlistId).get();
			
			Product product = productServiceImpl.getProductById(productId);
			
			wishlist.getProducts().add(product);
			
			return wishlistRepo.save(wishlist);
			
		}catch (DataAccessException ex) {
            throw new UserServiceException("Failed to add product to wishlist ", ex);
        }
		
		
	}
	
	@Override
	public Wishlist removeProductToWishlist(String wishlistId, String productId) {
		// TODO Auto-generated method stub
		
		try {
			  Wishlist wishlist = wishlistRepo.findById(wishlistId).get();
				
			  Product product = productServiceImpl.getProductById(productId);
				
			  wishlist.getProducts().remove(product);
				
			  return wishlistRepo.save(wishlist);
		}catch (DataAccessException ex) {
            throw new UserServiceException("Failed to remove product from wishlist ", ex);
        }
        
		
	}

}