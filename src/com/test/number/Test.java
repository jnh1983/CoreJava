package com.test.number;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testShort();
		// testDouble();
		//parseLong();
		divide();
	}
	
	public static void divide(){
		double x = 2.55;
		int y= 10;
		System.out.println(x + "/" + y +" = "+  (x/y) + "\t," + x%y);
		x = 10;
		System.out.println(x + "/" + y +" = "+  (x/y*100) + "\t," + x%y);
		x = 11;
		System.out.println(x + "/" + y +" = "+  (x/y*100) + "\t," + x%y);
	}
	
	public static void parseLong(){
		String str = "100";
		Long num = Long.valueOf(101l);
		System.out.println(Long.valueOf(String.valueOf(str)));
		System.out.println(Long.valueOf(String.valueOf(num)));
	}

	public static void testDouble() {
		double num = getDouble("57.00", 56);
		log(num);

		num = getDouble("aa", 56);
		log(num);

		num = getDouble("", 56);
		log(num);

		num = getDouble(null, 56);
		log(num);
	}

	public static double getDouble(String str, double defaultValue) {
		double result = defaultValue;
		try {
			result = Double.valueOf(str);
		} catch (Exception e) {
			// result = defaultValue;
		}
		return result;
	}

	public static void testShort() {
		short num = 0;
		log(num);

		num = (short) 5.06;
		log(num);

		num = Double.valueOf("12.36").shortValue();
		log(num);

		num = Short.valueOf("57");
		log(num);
	}

	public static void log(Object num) {
		System.out.println(num);
	}

}
