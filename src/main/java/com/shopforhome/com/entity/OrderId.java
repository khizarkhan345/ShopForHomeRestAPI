package com.shopforhome.com.entity;




import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;



public class OrderId implements Serializable{

	private UUID userId;
	private UUID productId;
	private LocalDate orderDate;
	
	public OrderId() {
		
	}

	public OrderId(UUID userId, UUID productId, LocalDate orderDate) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
	}
	


	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        OrderId that = (OrderId) o;
	        return userId == that.userId && Objects.equals(productId, that.productId) && Objects.equals(orderDate, that.orderDate);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(userId, productId, orderDate);
	    }
}

