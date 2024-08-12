package com.shopforhome.com.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.shopforhome.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User findUserByEmail(@Param("email") String email);
}
