package com.shopforhome.com.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="wishlist")
@IdClass(CartId.class)
public class Wishlist {

	@Id
	@Column(name="user_id")
	private UUID userId;
	@Id
	@Column(name="product_id")
	private UUID productId;
	
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToMany
	@JoinColumn(name="productId")
	private List<Product> products;
	
	public Wishlist() {
		
	}

	public Wishlist(UUID userId, UUID productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
