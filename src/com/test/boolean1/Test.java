package com.test.boolean1;

public class Test {

	public static void main(String[] args) {
		convert("true");
		convert("TRUE");
		convert("false");
		convert("nothing");
		convert(null);
	}
	
	public static void convert(String p_str){
		System.out.println(p_str + "\t" + Boolean.valueOf(p_str));
	}

}
