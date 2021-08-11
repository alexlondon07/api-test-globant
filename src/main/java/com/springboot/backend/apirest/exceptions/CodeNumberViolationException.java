package com.springboot.backend.apirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CodeNumberViolationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CodeNumberViolationException(String message) {
		super(message);
	}
}
