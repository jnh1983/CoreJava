package com.test.lang;

public class TestCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printChars(0, 129);
	}

	public static void printChars(int p_start, int p_end) {
		for (int i = p_start; i < p_end; i++) {
			System.out.println(i + ":\t" + (char) i);
		}
	}
}
