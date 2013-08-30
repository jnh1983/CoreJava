package com.test;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class HelloWorld {

	protected boolean trueValue = true;
	protected boolean falseValue = false;
	protected static boolean isValue;

	public static void main(String[] args) {
		// specialChar();
		// foo();
//		testBoolean();
//		testUnlabledBreak();
		testLabledBreak();
	}

	public static void testUnlabledBreak() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 1 && j == 5) {
					System.out.println("Break: i=" + i + ", j=" + j);
					break;
				}
			}
			System.out.println("Loop: i = " + i);
		}
	}
	
	public static void testLabledBreak() {
		search:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 1 && j == 5) {
					System.out.println("Break: i=" + i + ", j=" + j);
					break search;
				}
			}
			System.out.println("Loop: i = " + i);
		}
	}
	
	public static void testBoolean() {
		Object obj = true;
		System.out.println((Boolean) obj);
		obj = null;
		System.out.println((Boolean) obj);
		System.out.println((Boolean.valueOf(obj.toString())));
	}
	
	public static void specialChar() {
		System.out.println("012345678901234567890123456789");
		System.out.println("aaa\tbbb");
		System.out.println("aaa\t\tbbb");

		System.out.println("012345678901234567890123456789");

		String str = "012345678901234567890123456789";
		str.replace(" ", "nbsp;");
		str.substring(0, 22);
	}

	private static void foo() {
		try {
			System.out.println("try");
			foo();
		} catch (Throwable e) {
			System.out.println("catch");
			foo();
		} finally {
			System.out.println("finally");
			foo();
		}
	}
}
