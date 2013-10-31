package com.test.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		test();
	}

	public static void test(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("aaa");
		linkedList.add("bbb");
		linkedList.add("ccc");
		System.out.println(linkedList);
		linkedList.addFirst("aa1");
		linkedList.addLast("zzz");
		System.out.println(linkedList);
	}
}
