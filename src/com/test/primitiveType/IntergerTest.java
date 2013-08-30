package com.test.primitiveType;

public class IntergerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntergerTest test = new IntergerTest();
		test.testWrapper();
		test.testNegative();
	}

	public void testWrapper(){
		testInteger(15);
		testInteger(0x0010);
	}
	
	public void testInteger(int p_num){
		System.out.println("Print Integer: " + p_num);
	}
	
	public void testNegative() {
		System.out.println(Integer.toBinaryString(8) + "\t-->" + 8);;
		for (int i = 7; i > -9; i--) {
			String result = Integer.toBinaryString(i);
			if (result.length() > 4) {
				result = result.substring(result.length() - 4);
			} else if (result.length() < 4) {
				result = getZeros(5 - result.length()) + result;
			}
			System.out.println(result + "\t-->" + i);
		}
	}

	private String getZeros(int p_len) {
		StringBuffer result = new StringBuffer();
		for (int i = 1; i < p_len; i++) {
			result.append("0");
		}
		return result.toString();
	}
}
