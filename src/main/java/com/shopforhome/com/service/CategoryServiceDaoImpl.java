package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.CategoryRepository;
import com.shopforhome.com.exception.NotFoundException;
import com.shopforhome.com.exception.UserServiceException;
import com.shopforhome.com.entity.Category;
import com.shopforhome.com.entity.Product;

@Service
public class CategoryServiceDaoImpl implements CategoryServiceDao{

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Category getCategoryById(String theId) {
		// TODO Auto-generated method stub
		try {
			return categoryRepo.findById(theId)
                    .orElseThrow(() -> new NotFoundException("Category with ID " + theId + " not found"));
		}catch(DataAccessException ex) {
			throw new UserServiceException("Category not found", ex);
		}
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		try {
			return categoryRepo.findAll();
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to fetch categories", ex);
		}
	}

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			if(category.getCategoryId() == null) {
				category.setCategoryId(UUID.randomUUID().toString());
			}
			return categoryRepo.save(category);
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to save the product", ex);
		}
	}

	@Override
	public Category updateCategory(Category category,
			String theId) {
		// TODO Auto-generated method stub
		 try {
			Category existingCategory = categoryRepo.findById(theId).get(); 
			existingCategory.setCategoryName(category.getCategoryName());
			
			return categoryRepo.save(existingCategory);
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to update the product", ex);
		}
	}

	@Override
	public boolean deleteCategoryById(String theId) {
		// TODO Auto-generated method stub
		 try {
	            Category category = getCategoryById(theId);
	            categoryRepo.deleteById(theId);
	            return true;
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to delete Category with ID " + theId, ex);
	        }
	}
	
	
	
}
