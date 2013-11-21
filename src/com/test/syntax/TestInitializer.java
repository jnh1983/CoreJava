package com.test.syntax;

/**
 * Test Static Initializer and Instance Initializer.
 * 
 * @author Joey
 *
 * @see http://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.6
 */
public class TestInitializer {

	static int sNumber;
	int number;
	
	static {
		System.out.println("MyTest:\t Static Initializer");
		sNumber = 10;
	}
	
	TestInitializer() {
		System.out.println("MyTest:\t Constructor");
		sNumber = 12;
		number = 22;
	}
	
	{
		System.out.println("MyTest:\t Instance Initializer");
		sNumber = 11;
		number = 21;
	}
	
	public static void main(String[] args) {		
		System.out.println("MyTest:\t Main");
		System.out.println("\t sNumber = " + sNumber);
		TestInitializer test = new TestInitializer();
		System.out.println("\t number = " + test.getNumber());
	}
	
	public int getNumber(){
		return number;
	}
}

