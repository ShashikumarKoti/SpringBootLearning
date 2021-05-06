package com.skoti.learning.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomExceptoinHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomExceptionResponse> handleAllExceptions(Exception exp) {
		CustomExceptionResponse response = new CustomExceptionResponse(new Date(), exp.getMessage(), ErrorConstants.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<CustomExceptionResponse> studNotFound(StudentNotFoundException exp) {
		CustomExceptionResponse response = new CustomExceptionResponse(new Date(), exp.getMessage(), ErrorConstants.NOT_FOUND);
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
}
