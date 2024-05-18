package com.example.cafe.Exception;

@SuppressWarnings("serial")
public class TakeOrderNotFoundException extends RuntimeException {
	
	 public TakeOrderNotFoundException(String message) {
	        super(message);
	    }

}
