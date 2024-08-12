package com.shopforhome.com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.User;
import com.shopforhome.com.service.UserServiceDaoImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceDaoImpl userDaoImpl;
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) throws Exception {
		
			return userDaoImpl.getUserById(id);
		
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userDaoImpl.getAllUsers();
	}
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		
		
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());
		
		System.out.println(newUser.getUserId());
		return userDaoImpl.saveUser(newUser);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUserById(@PathVariable String id) throws Exception {
		return userDaoImpl.deleteUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable String id) throws Exception {
		return userDaoImpl.updateUser(user, id);
	}
}
