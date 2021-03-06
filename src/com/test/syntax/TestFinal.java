package com.test.syntax;

/**
 * Test Static Initializer and Instance Initializer.
 * 
 * @author Joey
 *
 */
public class TestFinal {

	static int sNumber;
	int number;
	
	static {
		System.out.println("MyTest:\t Static Initializer");
		sNumber = 10;
	}
	
	{
		System.out.println("MyTest:\t Instance Initializer");
		sNumber = 11;
		number = 21;
	}
	
	TestFinal(){
		System.out.println("MyTest:\t Constructor");
		sNumber = 12;
		number = 22;
	}
	
	public static void main(String[] args) {		
		System.out.println("MyTest:\t Main");
		System.out.println("\t sNumber = " + sNumber);
		TestFinal test = new TestFinal();
		System.out.println("\t number = " + test.getNumber());
	}
	
	public int getNumber(){
		return number;
	}
}

