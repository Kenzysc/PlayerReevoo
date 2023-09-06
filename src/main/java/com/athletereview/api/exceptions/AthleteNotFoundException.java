package com.athletereview.api.exceptions;

public class AthleteNotFoundException extends RuntimeException {
	private static final long serialVerificationUID = 1;
	
	public AthleteNotFoundException(String message) {
		super(message);
	}
}
