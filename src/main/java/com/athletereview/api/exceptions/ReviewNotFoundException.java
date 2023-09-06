package com.athletereview.api.exceptions;

public class ReviewNotFoundException extends RuntimeException{
	private static final long serialVerificationUID = 1;

	public ReviewNotFoundException(String message) {
		super(message);
	}
		
}
