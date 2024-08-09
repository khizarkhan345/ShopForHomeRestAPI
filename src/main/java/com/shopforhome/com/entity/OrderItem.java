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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_item_id")
	private UUID orderItemId;
	@Column(name="order_id")
	private UUID orderId;
	@Column(name="product_id")
	private UUID productId;
	@Column(name="quantity")
	private long quantity;
	@Column(name="unit_price")
	private long unitPrice;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	public OrderItem() {
		
	}

    

	public OrderItem(UUID orderId, UUID productId, long quantity, long unitPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}



	public UUID getOrderItemId() {
		return orderItemId;
	}



	public void setOrderItemId(UUID orderItemId) {
		this.orderItemId = orderItemId;
	}



	public UUID getOrderId() {
		return orderId;
	}



	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
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



	public long getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	

}
