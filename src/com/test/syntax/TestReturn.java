package com.test.syntax;

import com.test.vo.Student;

public class TestReturn {

	public static void main(String[] args) {

		System.out.println("test1():\t" + new TestReturn().test1());
		System.out.println("test2():\t" + new TestReturn().test2());
		System.out.println("test3():\t" + new TestReturn().test3());
	}

	String test1() {
		System.out.println("------------Start test1()-----------------------");
		String mess = "kong";
		try {
			mess = "Return try Value";
			System.out.println("try is Executed…");
			return mess;
		} finally {
			mess = "Return finally Value";
			System.out.println("finally is Executed…");
		}
	}

	String test2() {
		System.out.println("------------Start test2()-----------------------");
		String mess = "kong";
		try {
			mess = "Return try Value";
			System.out.println("try is Executed…");
			throw new Exception();
		} catch (Exception e) {
			mess = "Return catch Value";
			System.out.println("catch is Executed…");
		} finally {
			mess = "Return finally Value";
			System.out.println("finally is Executed…");
		}

		return mess;
	}
	
	Student test3() {
		System.out.println("------------Start test3()-----------------------");
		Student stu = new Student(1, "Li4", 31);
		try {
			stu.setName("TryName");
			return stu;
		} finally {
			stu.setName("FinallyName");
		}
	}
	
}