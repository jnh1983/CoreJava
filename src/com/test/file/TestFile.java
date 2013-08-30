package com.test.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class TestFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File p_file = new File("C:/Users/QA-2/Desktop/temp/txt/Welocalize_Company.txt");
		createFile();
//		printFile(p_file);
	}
	
	public static void createFile() throws IOException{
		String parent = System.getProperty("user.home");
		parent += "/AppData/Local/Temp";
		System.out.println(parent);
		File file = new File(parent, "aa.txt");
		writeFile(file, Calendar.getInstance().getTime() + "\r\naaa");
		printFile(file, "Window 7 Test");
	}
	
	public static void printFile(File p_file, String p_mag) {
		
		try {
			System.out.println("AbsolutePath:\t"+p_file.getAbsolutePath());
			System.out.println("CanonicalPath:\t"+p_file.getCanonicalPath());
			System.out.println("Path:\t\t"+p_file.getPath());
			System.out.println("FreeSpace:\t"+p_file.getFreeSpace());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile(File file, String data) throws IOException
	{
		FileOutputStream out = new FileOutputStream(file);
		try
		{
			out.write(data.getBytes());
		}
		finally
		{
			if (out != null) out.close();
		}
	}

}
