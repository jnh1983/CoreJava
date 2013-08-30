package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollesctions {

	static final String SEPARATOR = "+gs+";
	
	public static void main(String[] args) {
		TestCollesctions test = new TestCollesctions();

//		test.testMaxFromCollections();
//		testSort();
		testSingletonList();
	}
	
	public static void testSingletonList() {
		// create an array of string objs
		String init[] = { "One", "Two", "Three", "One", "Two", "Three" };

		// create one list
		List<String> list = new ArrayList(Arrays.asList(init));
		list.add("Four");

		System.out.println("List value before:\t" + list);

		// create singleton list
		list = Collections.singletonList("TP");
		list.add("Four");

		System.out.println("List value after:\t" + list);
		list = new ArrayList(Arrays.asList(init));
		System.out.println("List value after:\t" + list);
	}
	
	public static void testSort() {
		List list = new ArrayList();
		
		list.add("kk" + SEPARATOR +"1026");
		list.add("kk" + SEPARATOR +"1025");
		list.add("a1" + SEPARATOR +"1026");
		list.add("aa" + SEPARATOR +"1026");
		list.add("ab" + SEPARATOR +"1026");
		list.add("aA" + SEPARATOR +"1026");
		list.add("1");
		list.add("2");
		list.add("11");
		
		
		print(list);
		 
		Collections.sort(list);
		print(list);
		
		printInt("1abcA+0!gs一二月北京。");
		String str = String.valueOf((char)23);
//		System.out.println(str);
	}

	@SuppressWarnings("unchecked")
	public void testMaxFromCollections() {
		String msg = "The Max value of Collections is ";
		List list = new ArrayList();

		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		System.out.println(msg + Collections.max(list) + "\t" + list.toString());

		list.add("a");
		list.add("a");
		System.out.println(msg + Collections.max(list) + "\t" + list.toString());
	}
	
	public static void print(List<?> p_list){
		System.out.println("Start Print List and size is " + p_list.size());
		for(Object obj : p_list){
			System.out.println(obj);
		}
		System.out.println("Finish Print ***************************** ");
	}
	
	public static void printInt(String p_str){
		System.out.println("Start Print string: " + p_str);
		for(char c : p_str.toCharArray()){
			System.out.println(c + "\t" + (int)c+ "\t" + Integer.toHexString((int)c));
		}
	}

}
