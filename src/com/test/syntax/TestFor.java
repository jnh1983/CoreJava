package com.test.syntax;

import java.util.ArrayList;
import java.util.List;

public class TestFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testFor();
		testReturn();
	}

	public static void testReturn() {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 6)
					return;
				System.out.print("Print [" + i + ", " + j + "], ");
			}
			if (i == 6)
				return;
			System.out.println("\nFinished First For Loop with value " + i);
		}
	}
	
	public static void testFor() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();

		for (String str : list) {
			System.out.print(str + ", ");
		}
		System.out.println();
	}

}
