package com.example.cafe.Service;

import java.util.List;


import com.example.cafe.Entity.Order;

public interface OrderService {
	
	
	public List<Order>getAllOrders();
	
	public Order getOrderById(long orderId);
	
	public void deleteOrder( long orderId);
	
	public Order saveOrder(Order order);
	
	public List<Order> findOdersByUserId (long userId);
	
}
