package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.WishlistRepository;
import com.shopforhome.com.entity.Product;
import com.shopforhome.com.entity.User;
import com.shopforhome.com.entity.Wishlist;

@Service
public class WishlistServiceDaoImpl implements WishlistServiceDao {

	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Autowired
	private ProductServiceDaoImpl productServiceImpl;
	
	@Override
	public Wishlist saveWishlist(User user) {
		// TODO Auto-generated method stub
		Wishlist wishlist = new Wishlist();
		wishlist.setUser(user);
		wishlist.setWishlistId(UUID.randomUUID().toString());
		return wishlistRepo.save(wishlist);
	}
	@Override
	public List<Wishlist> getAllWishListProducts() {
		// TODO Auto-generated method stub
		return wishlistRepo.findAll();
	}
	
	@Override
	public Wishlist addProductToWishlist(String wishlistId, String productId) {
		// TODO Auto-generated method stub
		
		Wishlist wishlist = wishlistRepo.findById(wishlistId).get();
		
		Product product = productServiceImpl.getProductById(productId);
		
		wishlist.getProducts().add(product);
		
		return wishlistRepo.save(wishlist);
	}
	
	@Override
	public Wishlist removeProductToWishlist(String wishlistId, String productId) {
		// TODO Auto-generated method stub
         Wishlist wishlist = wishlistRepo.findById(wishlistId).get();
		
		Product product = productServiceImpl.getProductById(productId);
		
		wishlist.getProducts().remove(product);
		
		return wishlistRepo.save(wishlist);
		
	}

}