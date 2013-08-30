package com.test.math.bigDecimal;

import java.math.BigDecimal;

public class SetRide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double  d = 75.4534567;
		//BigDecimal big = new BigDecimal(String.valueOf(d));
		//System.out.print(big.setScale(2,BigDecimal.ROUND_HALF_DOWN));
		rondingMode(d,2);
		rondingMode(d,3);
		rondingMode(d,4);
		rondingMode(d,5);
		rondingMode(d,6);
	}
	
	public static void rondingMode(double d, int scale){
		BigDecimal big = new BigDecimal(String.valueOf(d));
		System.out.print(big.setScale(scale,BigDecimal.ROUND_HALF_DOWN)+"\t");
		System.out.print(big.setScale(scale,BigDecimal.ROUND_HALF_EVEN)+"\t");
		System.out.print(big.setScale(scale,BigDecimal.ROUND_HALF_UP)+"\t");
		
		System.out.print(big.setScale(scale,5)+"\t");
		System.out.print(big.setScale(scale,6)+"\t");
		System.out.print(big.setScale(scale,4)+"\t");
		
		System.out.println();
	}
	
	

}
