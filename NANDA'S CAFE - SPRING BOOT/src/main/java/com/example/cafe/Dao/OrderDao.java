package com.example.cafe.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.Entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>{
	
	public List<Order> findByOrderId(long orderId);
	
	List<Order> findByUserUserId(long userId);


}
