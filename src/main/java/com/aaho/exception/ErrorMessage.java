package com.aaho.exception;

public class ErrorMessage {
	private String message;
	private  String Severity  ;

	
	public ErrorMessage(){
	}
	
	public ErrorMessage(String message, String severity) {
		super();
		this.message = message;
		Severity = severity;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	} 
}
