package com.test.string;

public class SpecialCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hello World";
		//nextLineString();
		nextLineStringBuffer();
		
		System.out.println(str.replace(' ', '\u0020'));
	}
	
	public static void nextLineString(){
		String str = "Hello World";
		System.out.println(str);
		str += "\nWelocome";
		System.out.println(str);
	}
	
	public static void nextLineStringBuffer(){
		StringBuffer str = new StringBuffer("Hello World-->");
		System.out.println(str);
		str .append("Hello World\r\nWelocome\r\n\r\nto\r\rchina!") ;
		System.out.println(str);
	}

}
