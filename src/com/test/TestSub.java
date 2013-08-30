package com.test;

public class TestSub extends TestSuper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSub test = new TestSub();
		test.printWrap();
	}

	public void printWrap() {
		setMsg("AAA");
		
		print();
		this.print();
		super.print();
	}
	
	@Override
	public void print() {
		System.out.println("SubClass:" + getMsg());
	}
}
