package com.test.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestRuntime {

	static String charsetName = System.getProperty("sun.jnu.encoding");

	public static void main(String[] args) throws IOException {

		Process process = Runtime.getRuntime().exec("notepad.exe");
		// printIpconfig();
	}

	public static void printIpconfig() throws IOException {
		Process process = Runtime.getRuntime().exec("ipconfig");
		getResult(process, true);
	}

	public static List<String> getResult(Process p_process, boolean p_isPrint) throws IOException {
		List<String> result = new ArrayList<String>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(p_process.getInputStream(), charsetName));
			String line;

			while ((line = in.readLine()) != null) {
				if (p_isPrint) {
					System.out.println(line);
				}

				result.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}

		return result;
	}

}
