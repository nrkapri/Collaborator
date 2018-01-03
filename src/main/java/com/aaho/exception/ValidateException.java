package com.aaho.exception;

public class ValidateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private  String Severity  ; 


	public ValidateException(String severity, String message) {
		super();
		this.message = message;
		Severity = severity;
	}

	public ValidateException() {
	}

	public String getMessage() {
		return message;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
}
