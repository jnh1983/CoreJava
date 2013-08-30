package com.test.collection;

import java.util.LinkedList;

public class TestLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testOperate();

	}

	public static void testOperate(){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("First03");
		list.addFirst("First02");
		list.addLast("Last02");
		list.addLast("Last03");
		System.out.println(list);
		System.out.println("First:" + list.getFirst() + "\t 2:" + list.get(2) + "\tLast:" + list.getLast());
		list.add("newValue");
	}
}
