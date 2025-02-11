package com.aitech.user.customException;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource not fund Exception !! ");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
