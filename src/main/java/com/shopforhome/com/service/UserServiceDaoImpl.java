package com.shopforhome.com.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.entity.User;
import com.shopforhome.com.exception.UserNotFoundException;
import com.shopforhome.com.exception.UserServiceException;
import com.shopforhome.com.dao.UserRepository;

@Service
public class UserServiceDaoImpl implements UserServiceDao{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User getUserById(String theId) throws Exception {
		// TODO Auto-generated method stub
		try {
            return userRepo.findById(theId)
                           .orElseThrow(() -> new UserNotFoundException("User with ID " + theId + " not found"));
        } catch (DataAccessException ex) {
            // Log the exception (using a logging framework) and throw a custom exception
            throw new UserServiceException("Failed to retrieve user with ID " + theId, ex);
        }
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		try {
			return userRepo.findAll();
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to retrieve users", ex);
		}
		
	}

	@Override
	public boolean deleteUserById(String theId) throws Exception{
		// TODO Auto-generated method stub
		  try {
	            User user = getUserById(theId);
	            userRepo.deleteById(theId);
	            return true;
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to delete user with ID " + theId, ex);
	        }
		
	}

	@Override
	public User updateUser(User user, String theId) throws Exception {
		// TODO Auto-generated method stub
		 try {
	            User existingUser = getUserById(theId);
	            existingUser.setFirstName(user.getFirstName());
	            existingUser.setLastName(user.getLastName());
	            existingUser.setEmail(user.getEmail());
	            existingUser.setPassword(user.getPassword());
	            return userRepo.save(existingUser);
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to update user with ID " + theId, ex);
	        }
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		 try {
	          if (user.getUserId() == null) {
	               user.setUserId(UUID.randomUUID().toString());
	          }
	           return userRepo.save(user);
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to save user", ex);
	      }
	}

}
