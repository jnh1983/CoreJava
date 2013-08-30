package com.test.math.bigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestBigDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setScale();
		double d1 = 1269.37;
        double d2 = 129.37;
		compareDoubleAndDecimal(d1,d2);  
		
		negative(new BigDecimal("-12.1456"));
		integer(new BigDecimal("12.1456"));
	}
	
	public static void compareDoubleAndDecimal(double d1, double d2){
		BigDecimal bigDec1 = new BigDecimal(String.valueOf(d1));
        BigDecimal bigDec2 = new BigDecimal(String.valueOf(d2));
        BigDecimal bigDecSum = bigDec1.add(bigDec2); 
		
		double doubleSum = d1 + d2;

		System.out.println(d1+"\t"+d2);
		System.out.println("bigDecSum = " + bigDecSum);
        System.out.println("doubleSum = " + doubleSum);
        
	}
	
	public static void setScale() {
		// 方法１：
		// 保证精度的同时要求四舍五入：
		double f = 34.234566;
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		// b.setScale(2, BigDecimal.ROUND_HALF_UP) 表明四舍五入，保留两位小数，想保留几位将数字2该动就行
		System.out.println(f1);
		// 上面是对double类型的处理，如果对float的，则将上面所有的double字段换成float就行

		// 方法２：
		float scale = 34.232323f;
		DecimalFormat fnum = new DecimalFormat("##0.00");// 保留两位小数
		String dd = fnum.format(scale);
		System.out.println(dd);

	}
	
	public static void negative(BigDecimal big){
		System.out.println(big+"\t\t"+big.negate());
	}
	
	public static void integer(BigDecimal big){
		System.out.println(big+"\t\t"+big.setScale(0,BigDecimal.ROUND_HALF_UP));
	}
}
