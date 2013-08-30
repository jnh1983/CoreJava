package com.test.string;

public class TestTrim {

	public static String str;
	
	public static void main(String[] args) {
		
		printAndTrimWrapper();
	}
	
	public static void printAndTrimWrapper(){	
		int i=0;
		str = "  aaa bbb ";
		printAndTrim(str, ++i);
		
		str = "  \t ";
		printAndTrim(str, ++i);
		
		str = "  \n ";
		printAndTrim(str, ++i);

		str = "  aaa bbb  ";
		printAndTrim(str, ++i);
		
	}
	
	public static String printAndTrim(String str, int index){
		String end = "#FINISHED";
		System.out.println(index+":"+str+end);
		String result = str.trim();
		System.out.println(index+":"+result+end);
		return result;
	}

}
