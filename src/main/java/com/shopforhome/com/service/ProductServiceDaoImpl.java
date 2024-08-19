package com.shopforhome.com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shopforhome.com.dao.ProductRepository;
import com.shopforhome.com.entity.Product;
import com.shopforhome.com.exception.NotFoundException;
import com.shopforhome.com.exception.UserServiceException;

@Service
public class ProductServiceDaoImpl implements ProductServiceDao{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product getProductById(String theId) {
		// TODO Auto-generated method stub
		try {
			return productRepo.findById(theId)
                    .orElseThrow(() -> new NotFoundException("Product with ID " + theId + " not found"));
		}catch(DataAccessException ex) {
			throw new UserServiceException("Product not found", ex);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		try {
			return productRepo.findAll();
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to fetch products", ex);
		}
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			if(product.getProductId() == null) {
				product.setProductId(UUID.randomUUID().toString());
			}
			return productRepo.save(product);
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to save the product", ex);
		}
	}

	@Override
	public Product updateProduct(Product product, String theId) {
		// TODO Auto-generated method stub
		try {
			Product existingProduct = productRepo.findById(theId).get(); 
			existingProduct.setTitle(product.getTitle());
			existingProduct.setImageURL(product.getImageURL());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setStock(product.getStock());
			existingProduct.setDescription(product.getDescription());
			return productRepo.save(existingProduct);
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to update the product", ex);
		}
	}

	@Override
	public boolean deleteProduct(String theId) {
		// TODO Auto-generated method stub
		 try {
	            Product product = getProductById(theId);
	            productRepo.deleteById(theId);
	            return true;
	        } catch (DataAccessException ex) {
	            throw new UserServiceException("Failed to delete Product with ID " + theId, ex);
	        }
	}

	@Override
	public Product updateProductStock(long newStock, String theId) {
		// TODO Auto-generated method stub
		try {
			Product existingProduct = productRepo.findById(theId).get(); 
			existingProduct.setStock(newStock);
			return productRepo.save(existingProduct);
		}catch(DataAccessException ex) {
			throw new UserServiceException("Failed to update the product", ex);
		}
	}

}
