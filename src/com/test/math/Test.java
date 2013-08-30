package com.test.math;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testPow(4, 3);
		testPow(1.08, 10);
		testPow(1.09, 10);
		testPow(4, 1d/2);
		testPow(2, 1d/10);
		testPow(2, 1d/5);
	}

	public static void testPow(double p_a, double p_b) {
		System.out.println("POW(" + p_a + ", " + p_b 
				+ ")\t= " + Math.pow(p_a, p_b));
	}
}
