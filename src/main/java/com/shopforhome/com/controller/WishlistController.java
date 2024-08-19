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

import com.shopforhome.com.entity.Wishlist;
import com.shopforhome.com.request.WishlistItemDeleteRequest;
import com.shopforhome.com.request.WishlistItemRequest;
import com.shopforhome.com.service.WishlistServiceDaoImpl;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin
public class WishlistController {

	@Autowired
	private WishlistServiceDaoImpl wishlistServiceImpl;
	
	@GetMapping("/wishlistItems/{id}")
	public Wishlist getAllWishListItemsById(@PathVariable String id) {
		return wishlistServiceImpl.getAllWishlistItemsById(id);
	}
	
	@PostMapping("/save")
	public Wishlist addProductToWishlist(@RequestBody WishlistItemRequest wishlistItemReq) {
		return wishlistServiceImpl.addProductToWishlist(wishlistItemReq.getWishlistId(), wishlistItemReq.getProductId());
	}
	
	@PutMapping("/{id}")
	public boolean removeProductFromWishlist(@RequestBody WishlistItemDeleteRequest wishlistItemReq, @PathVariable String id) {
		return wishlistServiceImpl.removeProductFromWishlist(id, wishlistItemReq.getProductId());
	}
	
}
