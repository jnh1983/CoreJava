package com.test.collection.list;

import java.util.LinkedList;
import java.util.List;

import com.test.vo.Student;

public class LinkedListTest {

	public static void main(String[] args) {
//		test();
		testReference();
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
	
	public static void testReference(){
		List<Student> list = new LinkedList<Student>();
		Student stu1 = new Student(1);
		list.add(stu1);
		list.add(new Student(2));
		list.add(new Student(3));
		System.out.println(list);
		stu1.setName("NewName01");
		System.out.println(list);
	}
}
