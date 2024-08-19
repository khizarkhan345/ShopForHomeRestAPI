package com.shopforhome.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.CartItems;
import com.shopforhome.com.entity.User;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, String> {
	
	@Query("SELECT c FROM CartItems c WHERE c.cart.cartId = :cartId")
	public List<CartItems> getCartItemsByCartId(@Param("cartId") String cartId);

}
