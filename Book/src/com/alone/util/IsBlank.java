package com.alone.util;


/**
 * @author object
 */
public class IsBlank {
	private static final String BLANK = "";
	private IsBlank() {
		
	}
	public static boolean isBlank(Object object) {
		if(object == null || BLANK.equals(object)) {
			return false;
		}
		return true;
	}

}
