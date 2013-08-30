package com.test.syntax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerial {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception{
		TestSerial test = new TestSerial();
		File file = new File("out.ser");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        SerializeMe serializeMe = test.new SerializeMe("1");
        oos.writeObject(serializeMe);
        oos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        SerializeMe dto = (SerializeMe) ois.readObject();
        System.out.println("data : " + dto.getData());
        ois.close();


	}
	
	public class SerializeMe implements Serializable {

		private static final long serialVersionUID = 1409371394795549962L;
		private String data;

		public SerializeMe(String p_data) {
			data = p_data;
		}

		public String getData() {
			return data;
		}
	}
}


