package com.shopforhome.com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String>{

}
