package com.test.math.bigDecimal;

import java.math.BigDecimal;

public class Algorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		powerWrapper(95.123,12);
		powerWrapper(0.4321,20);
		powerWrapper(5.1234,15);
		powerWrapper(6.7592,9);
		powerWrapper(98.999,10);
		powerWrapper(1.0100,12);		
	}
	
	public static void powerDoubleWrapper(double x, int y){
		double result = powerDouble(x,y);
		System.out.println(format(result));
	}
	
	public static void powerWrapper(double x, int y){
		String result = power(x,y);
		System.out.println(format(result));
	}
	
	public static double powerDouble(double x, int y){
		BigDecimal b1 = new BigDecimal(String.valueOf(x));		
		return b1.pow(y).doubleValue();
	}
	
	public static String power(double x, int y){
		BigDecimal b1 = new BigDecimal(String.valueOf(x));		
		return b1.pow(y).toPlainString();
	}
	
	public static String format(Object x){
		
		String regex1 = "^0\\..*$";
		String regex2 = "^.*\\.0*$";
		String regex3 = "^0\\.0*$";
		String result = String.valueOf(x);
		if(result.matches(regex3)){
			result = "0";
		}
		else if(result.matches(regex1)){
			result = result.replace("0.", ".");
		}
		else if(result.matches(regex2)){
			int index = result.indexOf('.');
			result = result.substring(0, index);
		}
		
		return result;
	}

}
