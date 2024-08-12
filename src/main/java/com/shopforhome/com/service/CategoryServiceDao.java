package com.shopforhome.com.service;

import java.util.List;

import com.shopforhome.com.entity.Category;

public interface CategoryServiceDao {

	public Category getCategoryById(String theId);
	public List<Category> getAllCategories();
	public Category saveCategory(Category category);
	public Category updateCategory(Category category, String theId);
	public boolean deleteCategoryById(String theId);
}
