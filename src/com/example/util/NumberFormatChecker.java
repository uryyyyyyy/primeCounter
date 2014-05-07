package com.example.util;

import java.util.logging.Logger;


public class NumberFormatChecker {
	private static final Logger logger = Logger.getLogger("NumberFormatChecker");
	private static final String NPE_MEG = "null desu";
	private static final String NEGATIVE_ERROR_MSG = "mainasu desu";
	private static final String CONVERT_ERROR_MSG = "cannot convert to int";
	
	public static void checkNotNull (Integer number){
		if(number == null){
			logger.warning(NPE_MEG);
			throw new NumberFormatException();
		}
	}
	
	public static void checkNotNegative (Integer number){
		if(number < 0){
			logger.warning(NEGATIVE_ERROR_MSG + " -> " + number);
			throw new NumberFormatException();
		}
	}
	
	public static Integer toInteger(String input){
		try{
			return Integer.valueOf(input);
		}catch(NumberFormatException e) {
			logger.warning(input + CONVERT_ERROR_MSG);
			throw e;
		}
	}
}
