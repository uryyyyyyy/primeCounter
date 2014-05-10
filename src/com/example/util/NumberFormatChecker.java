package com.example.util;

import java.util.logging.Logger;


public class NumberFormatChecker {
	private static final Logger logger = Logger.getLogger("NumberFormatChecker");
	private static final String CONVERT_ERROR_MSG = "cannot convert to int";
	
	public static int toInteger(String str){
		try{
			return Integer.valueOf(str).intValue();
		}catch(NumberFormatException e) {
			logger.warning(str + CONVERT_ERROR_MSG);
			throw e;
		}
	}
}
