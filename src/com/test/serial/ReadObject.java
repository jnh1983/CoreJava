package com.test.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * http://www.mkyong.com/java-best-practices/understand-the-serialversionuid/
 */
public class ReadObject {

	public static void main(String args[]) {

		Address address;

		try {
			File file = new File(WriteObject.fileName);
			if (!file.exists())
				WriteObject.main(null);

			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fin);
			address = (Address) ois.readObject();
			ois.close();

			System.out.println(address);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
