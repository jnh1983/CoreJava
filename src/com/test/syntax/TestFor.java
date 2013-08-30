package com.test.syntax;

import java.util.ArrayList;
import java.util.List;

public class TestFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();
		
		for(String str: list){
			System.out.print(str + ", ");
		}
		System.out.println();
	}

}
