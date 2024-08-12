package com.shopforhome.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.Category;
import com.shopforhome.com.service.CategoryServiceDaoImpl;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryServiceDaoImpl categoryDaoImpl;
	
	@GetMapping("/{id}")
	public Category getProductById(@PathVariable String id) {
		return categoryDaoImpl.getCategoryById(id);
	}
	
	@GetMapping("/all")
	public List<Category> getAllProducts(){
		return categoryDaoImpl.getAllCategories();
	}
	
	@PostMapping("/save")
	public Category saveProduct(@RequestBody Category category) {
		return categoryDaoImpl.saveCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable String id) {
		return categoryDaoImpl.updateCategory(category, id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProduct(@PathVariable String id) {
		return categoryDaoImpl.deleteCategoryById(id);
	}
}
