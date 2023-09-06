package com.athletereview.api.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(AthleteNotFoundException.class)
		public ResponseEntity<ErrorObject> handleAthleteNotFoundException(AthleteNotFoundException ex, WebRequest request) {
			ErrorObject errorObject = new ErrorObject();
			
			errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
			errorObject.setMessage(ex.getMessage());
			errorObject.setTimestamp(new Date());
			
			return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(ReviewNotFoundException.class)
		public ResponseEntity<ErrorObject> handleReviewNotFoundException(ReviewNotFoundException ex, WebRequest request) {
			ErrorObject errorObject = new ErrorObject();
			
			errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
			errorObject.setMessage(ex.getMessage());
			errorObject.setTimestamp(new Date());
			
			return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
		}
}
