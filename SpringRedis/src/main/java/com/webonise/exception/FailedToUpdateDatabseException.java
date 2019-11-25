package com.webonise.exception;

public class FailedToUpdateDatabseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FailedToUpdateDatabseException(String message) {
		super(message);
	}
}
