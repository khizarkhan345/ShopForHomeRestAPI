package com.shopforhome.com.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_items")
public class CartItems {
	
	@Id
	@Column(name = "cart_item_id")
	private String cartItemId;

//	@Column(name="cart_id")
//	private UUID cartId;
//	
//	@Column(name="product_id")
//	private UUID productId;
//	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "quantity")
	private long quantity;
	
	public CartItems() {
		
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

//	public Cart getCart() {
//		return cart;
//	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	

}
