package com.example.cafe.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "order_id")
	 private long orderId;
	 
	 @ManyToOne
	 private User user;
	 
	 @ManyToOne
	 private Food food;
	 
	 private Date orderDate;
	 
	 private Date orderTime;
	 
	 private int quantity;
	 
	 private double totalPrice; 
	 
	 
	 public Order() {
		 
		 this.orderDate = new Date();
	       this.orderTime = new Date(); 
		 
	 }
	 
	 
	 public Order(long orderId, User user, Food food, Date orderDate, Date orderTime, int quantity, double totalPrice) {
		 super();
		 this.orderId = orderId ;
		 this.user = user; 
		 this.food = food; 
		 this.quantity = quantity; 
	 }
	 

	    


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(	User user) {
		this.user = user;
	}


	public Food getFood() {
		return food;
	}


	public void setFood(Food food) {
		this.food = food;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Date getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	 
	 
}
