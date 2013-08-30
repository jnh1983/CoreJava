package com.test.string;

import java.io.UnsupportedEncodingException;

public class Encoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "bbbbbåŒ—äº¬æ¬¢è¿Žä½ ã€‚";
		test(str);
		str = "bbbbb北京欢迎你‚";
		test(str);

	}
	
	public static void test(String str){
		String result;
		System.out.println(str);
		try {
			result = new String(str.getBytes(),"UTF-8");
			System.out.println(result);
			result = new String(str.getBytes("ISO8859-1"),"UTF-8");
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
