package com.aitech.hotel.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String s) {
		super(s);		
	}
	public ResourceNotFoundException() {
	
		super("Resource not found !!");
	}
}
