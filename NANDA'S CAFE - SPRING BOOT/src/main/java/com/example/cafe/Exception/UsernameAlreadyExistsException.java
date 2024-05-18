package com.example.cafe.Exception;

public class UsernameAlreadyExistsException {
	
	public UsernameAlreadyExistsException(String username) {
		 super();
		 System.out.println("User already exists with ID: " + username);
	}
}
