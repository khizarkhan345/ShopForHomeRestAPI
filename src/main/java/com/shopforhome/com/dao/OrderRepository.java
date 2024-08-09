package com.shopforhome.com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<UUID, Order> {

}
