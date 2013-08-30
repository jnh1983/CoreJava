package com.test.syntax;

public class TestByte {

	static byte[] a = { 0, 1, 2, 3 };
	static byte[] b = { 0, 1, 2, 3 };
	
	public static void main(String[] args) {
		testBiteWishAnd();
	}
	
	public static void testBiteWishAnd() {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.println(Integer.toBinaryString(a[i]) + "&" + Integer.toBinaryString(b[j]) + "=\t" + Integer.toBinaryString((a[i] & b[j])));
			}
		}
	}

}
