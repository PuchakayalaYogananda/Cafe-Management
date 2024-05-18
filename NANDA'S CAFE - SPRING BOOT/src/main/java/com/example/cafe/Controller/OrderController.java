package com.example.cafe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.Entity.Order;
import com.example.cafe.Service.FoodService;
import com.example.cafe.Service.OrderService;

@RestController
@CrossOrigin("*	")
@RequestMapping("/api/orders")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	FoodService foodService;
	
	@GetMapping("/vieworders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
	
	
	@GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
	
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/create")
	    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		 
		 	double totalPrice = order.getFood().getFoodPrice() * order.getQuantity();
	        
	        order.setTotalPrice(totalPrice);
	        Order savedOrder = orderService.saveOrder(order);
	        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	        
	     
	    }
	 

	 @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable long userId) {
	        List<Order> orders = orderService.findOdersByUserId(userId);
	        if (orders != null) {
	            return new ResponseEntity<>(orders, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}