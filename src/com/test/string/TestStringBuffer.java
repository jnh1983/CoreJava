package com.test.string;

public class TestStringBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<5; i++){
			sb.append(i).append(", ");
		}
		System.out.println(sb);
		
		System.out.println(sb+"#\t:"+sb.length());		
		sb.delete(sb.lastIndexOf(","), sb.length());
		System.out.println(sb+"#\t:"+sb.length());
		
		sb.insert(0, "AAA: ");
		System.out.println(sb);

	}

}
