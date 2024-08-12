package com.shopforhome.com.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="wishlist")
public class Wishlist {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="wishlist_id")
	private UUID wishlistId;
	
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany
	@JoinTable(
		name = "wishlist_products",
		joinColumns = @JoinColumn(name = "wishlist_id"),
		inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> products;
	
	public Wishlist() {
		
	}

	public Wishlist(UUID userId, UUID productId) {
		super();
		
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
