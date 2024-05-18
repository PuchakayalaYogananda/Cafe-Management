package com.example.cafe.Exception;

@SuppressWarnings("serial")
public class FoodNotFoundException extends RuntimeException {
	
	public FoodNotFoundException(long orderId) {
		super("Food not found with id: " +orderId);
        
	}

}
