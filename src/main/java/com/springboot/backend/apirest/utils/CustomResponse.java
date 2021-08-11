package com.springboot.backend.apirest.utils;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class CustomResponse<T> {

	private boolean success;
	private String message;
	private int statusCode;
	private HttpStatus httpStatus;
	private T data;

	public CustomResponse() {

	}

	public CustomResponse(boolean success, String message) {
		this(success, message, 200, null);
	}

	public CustomResponse(T data) {
		this(true, "sucsess", 200, data);
	}

	public CustomResponse(boolean success, String message, int statusCode, T data) {
		super();
		this.success = success;
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	
	public CustomResponse(boolean success, String message, int statusCode) {
		super();
		this.success = success;
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public CustomResponse(boolean success, String message, HttpStatus httpStatus, T data) {
		super();
		this.success = success;
		this.message = message;
		this.httpStatus = httpStatus;
		this.data = data;
	}

	public CustomResponse(boolean success, String message, HttpStatus httpStatus) {
		super();
		this.success = success;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public static String getFielErrorResponse(BindingResult bindingResult) {
		List<String> errors = (List<String>) bindingResult.getFieldErrors()
				.stream()
				.map(err -> "El campo '" + err.getField()+ "' "+ err.getDefaultMessage())
				.collect(Collectors.toList());
		return errors.toString();
	}

}
