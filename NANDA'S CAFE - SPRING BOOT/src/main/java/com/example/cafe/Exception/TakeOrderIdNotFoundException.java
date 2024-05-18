package com.example.cafe.Exception;

@SuppressWarnings("serial")
public class TakeOrderIdNotFoundException extends RuntimeException {
	
	
	public TakeOrderIdNotFoundException(String message)
	{
		super(message);
	}

}
