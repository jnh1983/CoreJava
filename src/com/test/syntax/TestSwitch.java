package com.test.syntax;

public class TestSwitch {

	static int num;
	static char c;

	public static void main(String[] args) {
//		testDefaultWrapper();
//		testInputWrapper();
		testCaseWrapper();	
	}

	public static void testCaseWrapper(){
		for(int i=0; i<10; i++){
			testCase(i);
		}
	}
	
	public static void testCase(int p_num) {
		System.out.print("The input number is " + p_num + "\t");
		switch (p_num) {
		case 1:
		case 2:
		case 3:
			System.out.println("Less than 3...");
		case 4:
			System.out.println("Condition 4...");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("Less than 7...");	
			break;
	    default:
	    	System.out.println("Default Condition...");
	    	break;
		}
	}
	
	public static void testInputWrapper(){
		num = 10;
		c = 'A';
		 testInput();
		num = 2;
		c = 'c';
		testInput();
	}
	
	public static void testDefaultWrapper() {
		int i = 0;
		testDefault(i++);
		testDefault(i++);
		testDefault(i++);
		testDefault(i++);
	}

	public static void testDefault(int i) {
		switch (i) {
		default:
			System.out.println("The Default Condition, and input is " + i);
			break;
		case 1:
			System.out.println("First, and input is " + i);
			break;
		case 2:
			System.out.println("Second, and input is " + i);
			break;
		}
	}

	public static void testInput() {
		switch (num) {
		case 1:
			System.out.println("One:"+num);
			break;
		case 10:
			System.out.println("Ten:"+num);
			break;
		default:
			System.out.println("Default:" + num);
		}

		switch (c) {
		case 'a':
			System.out.println("a:"+c);
			break;
		case 'A':
			System.out.println("A:"+c);
			break;
		case 'b':
			System.out.println("b:"+c);
			break;
		case 'B':
			System.out.println("B:"+c);
			break;
		default:
			System.out.println("Default:" + c);
		}
	}

}
