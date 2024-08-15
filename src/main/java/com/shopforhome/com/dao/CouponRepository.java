package com.shopforhome.com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.com.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {

}
