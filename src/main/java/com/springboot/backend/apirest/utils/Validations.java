package com.springboot.backend.apirest.utils;

public class Validations {

	public static boolean isNumeric(String id) {
	    if (id == null) {
	        return false;
	    }
	    try {
	        double d = Long.parseLong(id);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
