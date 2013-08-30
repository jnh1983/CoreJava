package com.test.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class TestSystem {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printProperties();
	}

	public static void printProperties() {
		Properties ps = System.getProperties();
		List<String> keys = new ArrayList(ps.keySet());
		Collections.sort(keys);
		String prop;
		for (String key : keys) {
			prop = ps.getProperty(key);
			prop = prop.replace("\n", "\\n").replace("\r", "\\r");
			System.out.println(key + ":\t[" + prop + "]");
		}
	}
}
