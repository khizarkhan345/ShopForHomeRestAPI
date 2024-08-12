package com.shopforhome.com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
