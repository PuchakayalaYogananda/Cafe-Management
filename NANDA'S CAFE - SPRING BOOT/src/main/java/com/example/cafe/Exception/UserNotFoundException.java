package com.example.cafe.Exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	
	
    public UserNotFoundException(String uid) {
        super(uid);
    }

	public UserNotFoundException(Long uid) {
		System.out.println("User Id Not FOund");
	}


}
