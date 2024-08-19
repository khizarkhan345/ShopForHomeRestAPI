package com.shopforhome.com.service;

import java.util.List;

import com.shopforhome.com.entity.User;
import com.shopforhome.com.entity.Wishlist;

public interface WishlistServiceDao {
   
	 public List<Wishlist> getAllWishListProducts();
	 
	 public Wishlist addProductToWishlist(String wishlistId, String productId);
	 
	 public boolean removeProductFromWishlist(String wishlistId, String productId);
	 
	 public Wishlist saveWishlist(User user);
	 
	 public Wishlist getAllWishlistItemsById(String theId);
}
