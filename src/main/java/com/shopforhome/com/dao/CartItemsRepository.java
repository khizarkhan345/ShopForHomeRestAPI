package com.shopforhome.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, String> {

}
