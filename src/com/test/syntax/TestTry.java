package com.test.syntax;

/**
 * Test try/catch/finally/return
 */
public class TestTry {

	public static void main(String[] args) {
		TestTry test = new TestTry();
		test.testTryWrapper("normal", 0);
		// Ignore catch
		test.testTryWrapper("Ignore catch", 1);
		// Ignore finally return
		test.testTryWrapper("Ignore finally return", 2);
	}

	public void testTryWrapper(String p_msg, int p_input){
		System.out.println("["+p_msg.toUpperCase()+"]:");
		System.out.println(testTry(p_input));
		System.out.println("-------------------------");
	}
	
	public String testTry(int p_input) {
		try {
			System.out.println("try");
			if (p_input != 1) {
				throw new Exception();
			}
			return "ReturnFromTry";
		} catch (Exception ex) {
			System.out.println("catch");
			return "ReturnFromCatch";
		} finally {
			System.out.println("finally");
			if (p_input != 2) {
				return "ReturnFromFinally";
			}
		}
		// System.out.println("5");
	}

}
