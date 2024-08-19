package com.shopforhome.com.entity;

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
@Table(name="order_item")
public class OrderItem {
	
	@Id
	@Column(name="order_item_id")
	private String orderItemId;
	
	@Column(name="quantity")
	private long quantity;
	@Column(name="unit_price")
	private double unitPrice;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	public OrderItem() {
		
	}

    

	public OrderItem(long quantity, long unitPrice) {
		super();
		
	
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}



	public String getOrderItemId() {
		return orderItemId;
	}



	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}



	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



//	public Order getOrder() {
//		return order;
//	}
//
//

	public void setOrder(Order order) {
		this.order = order;
	}

    
    
	
	
	
	

}
