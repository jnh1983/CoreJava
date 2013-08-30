package com.test;

import java.net.URLEncoder;

public class Test {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Bike bike = new Bike("type1", 100);
		Bike bike2 = bike.clone();
		bike.setCost(101);
		bike2.setCost(102);
		System.out.println(bike);
		System.out.println(bike2);
		
		decode();
	}
	
	public static void decode()
	{
		String pass = "password001";
		System.out.println(pass);
		System.out.println(URLEncoder.encode(pass));
		System.out.println(Integer.valueOf(pass));
	}

}
