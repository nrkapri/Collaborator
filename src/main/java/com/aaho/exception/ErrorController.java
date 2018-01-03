package com.aaho.exception;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   

public class ErrorController {

	@ExceptionHandler(ValidateException.class)
	public ResponseEntity<ErrorMessage> handleValidateException(ValidateException ex) {
		return new ResponseEntity <ErrorMessage>(new ErrorMessage(ex.getSeverity(),ex.getMessage()),HttpStatus.OK);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintViolationException(Exception ex) {
		return new ResponseEntity <ErrorMessage>(new ErrorMessage("ERROR","Error due to constraint violation"),HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleAnyException(Exception ex) {
		return new ResponseEntity <ErrorMessage>(new ErrorMessage("ERROR","unknown error:"+ex.getMessage()),HttpStatus.OK);
	}
	
}