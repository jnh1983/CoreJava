package com.test;

import com.globalsight.util.GlobalSightLocale;

public class GSTestLocale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GlobalSightLocale gsL = new GlobalSightLocale("en","CA",false);
		println(gsL.getDisplayName());
		println(gsL.getCountry());

		gsL.setCountry("US");
		println(gsL.getDisplayName());
		println(gsL.getCountry());
	}

	public static void println(String str){
		System.out.println(str);
	}
}
