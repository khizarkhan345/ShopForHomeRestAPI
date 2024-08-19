package com.shopforhome.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.CartId;
import com.shopforhome.com.entity.CartItems;
import com.shopforhome.com.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, String>{

	@Query("SELECT w FROM Wishlist w WHERE w.wishlistId = :wishlistId")
	public Wishlist getAllWishlistItemsById(@Param("wishlistId") String wishlistId);
}
