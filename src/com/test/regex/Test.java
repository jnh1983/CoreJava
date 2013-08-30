package com.test.regex;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		simpleTest();
		test();
	}

	public static void test() {
		String str = "to your Waters service representative. <ph type=\"x-declaration\" x=\"1\">&lt;" +
				"![CDATA[  <ph type=\"LF\">[LF]</ph>]] &gt;</ph>" +
				"![CDATA[ ]]BBB![CDATA[  <ph type=\"LF\">[LF]</ph>]] &gt;</ph>";
//		str = "![CDATA[SSSSSSSSSSS";
		System.out.println(str);
		String pattern = "!\\[CDATA.*?\\]\\]";
		Pattern r = Pattern.compile(pattern);
		Matcher matcher = r.matcher(str);
		while(matcher.find())
		{
//			System.out.println("Find:" + matcher.group());
			String orig = matcher.group();
			str = str.replace(orig, orig.replace("<", "&lt;").replace(">", "&gt;"));
		}
		System.out.println("Finish!\n" + str);
	}
	
	public static void simpleTest() {
		String str = "zh-CN,zh-TW";
		Locale locale = Locale.SIMPLIFIED_CHINESE;
		System.out.println(str);
		System.out.println(locale.toString());

		if (str.matches("zh-..")) {
			str = str.replace("-", "_");
		}

		System.out.println(str);
		System.out.println(locale.toString());
	}

}
