package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import com.shopforhome.com.entity.User;

public interface UserServiceDao {

	public User getUserById(String theId);
	
	public User getUserByEmail(String email);
	
	public List<User> getAllUsers();
	
	public boolean deleteUserById(String theId) throws Exception;
	
	public User updateUser(User user, String theId) throws Exception;
	
	public User saveUser(User user);
	
}
