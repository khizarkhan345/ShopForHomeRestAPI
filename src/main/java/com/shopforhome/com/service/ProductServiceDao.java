package com.shopforhome.com.service;

import java.util.List;

import com.shopforhome.com.entity.Product;

public interface ProductServiceDao {

	public Product getProductById(String theId);
	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product product);
	
	public Product updateProduct(Product product, String theId);
	
	public boolean deleteProduct(String theId);
}
