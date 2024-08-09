package com.shopforhome.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.CartId;
import com.shopforhome.com.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<CartId, Wishlist>{

}
