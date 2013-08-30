package com.test.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {

	public static String fileName = "f:\\address.ser";
	
	public static void main(String args[]) {

		Address address = new Address();
		address.setStreet("Xi Dan");
		address.setCountry("China");

		try {

			FileOutputStream fout = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
