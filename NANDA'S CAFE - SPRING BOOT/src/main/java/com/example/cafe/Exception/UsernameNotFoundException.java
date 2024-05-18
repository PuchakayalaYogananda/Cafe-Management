package com.example.cafe.Exception;

public class UsernameNotFoundException {
	
	 public UsernameNotFoundException(long userId) {
	        super();
	        System.out.println("User not found with ID: " + userId);
	    }

}
