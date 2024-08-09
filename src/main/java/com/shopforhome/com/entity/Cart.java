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
@Table(name="cart")
@IdClass(CartId.class)
public class Cart {

	@Id
	@Column(name="user_id")
	private UUID userId;
	@Id
	@Column(name="product_id")
	private UUID productId;
	@Column(name="quantity")
	private long quantity;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToMany
	@JoinColumn(name="productId")
	private List<Product> products;
	
	public Cart() {
		
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
}
