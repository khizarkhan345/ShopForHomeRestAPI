package com.shopforhome.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.com.entity.Product;
import com.shopforhome.com.request.ProductRequest;
import com.shopforhome.com.service.ProductServiceDaoImpl;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductServiceDaoImpl productDaoImpl;
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable String id) {
		return productDaoImpl.getProductById(id);
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productDaoImpl.getAllProducts();
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productDaoImpl.saveProduct(product);
	}
	 
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable String id) {
		return productDaoImpl.updateProduct(product, id);
	}
	
	@PutMapping("/updateStock/{id}")
	public Product updateProductStock(@RequestBody ProductRequest productReq, @PathVariable String id) {
		return productDaoImpl.updateProductStock(productReq.getNewStock(), id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProduct(@PathVariable String id) {
		return productDaoImpl.deleteProduct(id);
	}
}
