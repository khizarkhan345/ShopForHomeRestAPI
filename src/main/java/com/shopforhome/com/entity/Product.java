package com.shopforhome.com.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private UUID productId;
	@Column(name="title")
	private String title;
	@Column(name="price")
	private String price;
	@Column(name="description")
	private String description;
	@Column(name="stock")
	private long stock;
	@Column(name="category_id")
	private UUID categoryId;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	@ManyToMany(mappedBy="cart", cascade=CascadeType.ALL)
	private List<Cart> cart; 
	
	@ManyToMany(mappedBy="products", cascade=CascadeType.ALL)
	private List<Wishlist> wishlist; 
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<OrderItem> orderItems;
	
	
	public Product() {
		
	}

	public Product(String title, String price, String description, long stock, UUID categoryId) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.categoryId = categoryId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
}
