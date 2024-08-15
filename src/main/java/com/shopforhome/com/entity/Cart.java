package com.shopforhome.com.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	@Column(name="cart_id")
	private String cartId;
	
//	@Column(name="user_id")
//	private UUID userId;
//	
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="cart", cascade= CascadeType.ALL, orphanRemoval = true)
	private List<CartItems> cartItems;
	
	public Cart() {
		
	}


	
	public List<CartItems> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	public String getCartId() {
		return cartId;
	}


	public void setCartId(String cartId) {
		this.cartId = cartId;
	}



	public void setUser(User user) {
		this.user = user;
	}



    





	
	
	
}
