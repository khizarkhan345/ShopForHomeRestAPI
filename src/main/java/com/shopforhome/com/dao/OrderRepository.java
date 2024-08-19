package com.shopforhome.com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
