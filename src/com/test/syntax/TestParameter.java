package com.test.syntax;

public class TestParameter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		passVarargsWrap();
	}

	public static void passVarargsWrap() {
		int[] array = { 1, 3, 5, 7, 9 };

		passVarargs(null);
		passVarargs(0, 1, 2);
		passVarargs(array);
	}

	public static void passVarargs(int... p_nums) {
		if (p_nums == null) {
			System.out.println("The input is NULL.");
		} else {
			System.out.print(p_nums.length + "\t[");
			for (int num : p_nums) {
				System.out.print(num + ", ");
			}
			System.out.println("]");
		}
	}
}
