package com.test.syntax;

import java.math.BigInteger;

public class TestReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long num1 = 3, num2 = 5;
		BigInteger bNum1 = new BigInteger(String.valueOf(num1));
		BigInteger bNum2 = new BigInteger(String.valueOf(num2));
		Student stu = new Student(num1);
		
		System.out.println("Number1:" + num1 + ",\tNumber2:" + num2);
		add(num1, num2);
		System.out.println("Number1:" + num1 + ",\tNumber2:" + num2);
		
		System.out.println("Number1:" + bNum1 + ",\tNumber2:" + bNum2);
		add(bNum1, bNum2);
		System.out.println("Number1:" + bNum1 + ",\tNumber2:" + bNum2);
		
		System.out.println("Student Number:" + stu.getNumber());
		add(stu);
		System.out.println("Student Number:" + stu.getNumber());
		
		System.out.println("Student Number:" + stu.getNumber());
		add2(stu);
		System.out.println("Student Number:" + stu.getNumber());
		
		System.out.println("Student Number:" + stu.getNumber());
		stu = add3(stu);
		System.out.println("Student Number:" + stu.getNumber());
	}

	public static void add(BigInteger p_inte1, BigInteger p_inte2){
		p_inte1 = p_inte1.add(p_inte2);
	}
	
	public static void add(long p_num1, long p_num2){
		p_num1 = p_num1 + p_num2;
	}
	
	public static void add(Student p_stu){
		p_stu.setNumber(40);
	}
	
	public static void add2(Student p_stu){
		p_stu = new Student(7);
		p_stu.setNumber(400);
	}
	
	public static Student add3(Student p_stu){
		p_stu = new Student(7);
		p_stu.setNumber(4000);
		return p_stu;
	}
	
}

class Student{
	long number;

	public Student(long number) {
		this.number = number;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	
}
