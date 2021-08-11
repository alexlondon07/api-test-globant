package com.springboot.backend.apirest.web;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
	
	public static ResponseEntity<Object> build(ApiError apiError) {
	      return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}