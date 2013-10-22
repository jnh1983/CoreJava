package com.test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.test.vo.Student;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSet t = new TestSet();
		 tString();
		t.tStudent();
	}

	public static void tString() {
		String str;
		Set set = new HashSet();
		str = set.toString();
		System.out.println(set + "\t" + set.size() + "\t" + str + "\t" + str.substring(1, str.length() - 1));
		
		set.add("set1");
		set.add("set2");
		set.add("set1");

		str = set.toString();
		System.out.println(set + "\t" + set.size() + "\t" + str + "\t" + str.substring(1, str.length() - 1));

		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("a");
		System.out.println(list);
	}

	public void tStudent() {
		Set set = new HashSet();
		Student s = new Student(1, "stu1", 1);
		Student s1 = new Student(1, "stu1", 1);
		set.add(s);
		set.add(s1);

		System.out.println(set.size() + "\t" + set);
	}

	

}
