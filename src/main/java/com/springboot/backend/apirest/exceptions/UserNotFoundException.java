package com.springboot.backend.apirest.exceptions;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
        super(message);
    }
}