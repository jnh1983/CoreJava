package com.test.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static final String email_Expr = "^([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";

	public static void main(String[] args) {
		// testEmail();
//		testSplit();
//		testGroup();
		testGroup2();
	}

	public static void testGroup() {
		Pattern p = Pattern.compile("(\\d+,)(\\d+)");

		String s = "123,456-34,345";
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println("m.group():" + m.group()); // 打印所有

			System.out.println("m.group(1):" + m.group(1)); // 打印数字的

			System.out.println("m.group(2):" + m.group(2)); // 打印字母的
			System.out.println();
		}

		System.out.println("捕获个数:groupCount()=" + m.groupCount());
	}
	
	public static void testGroup2() {
		Matcher m;
		String regex = "<a href=\"((http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?)\" target=\"_blank\">((http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?)</a>";
		Pattern pattern = Pattern.compile(regex);

		String s = "</div><a href=\"http://www.welocalize.com\" target=\"_blank\">http://www.welocalize.com</a>" +
		"<br><div><a href=\"https://10.10.214.33/globalsight\" target=\"_blank\">https://10.10.214.33/globalsight</a>";
		System.out.println("\n"+s);
		m = pattern.matcher(s);
		while (m.find()) {
			System.out.println();
			System.out.println("m.group():" + m.group()); // 打印所有

			System.out.println("m.group(1):" + m.group(1));
			System.out.println("m.group(2):" + m.group(2));
			System.out.println("m.group(3):" + m.group(3));
			System.out.println("m.group(4):" + m.group(4));
			System.out.println("m.group(5):" + m.group(5));
			System.out.println("m.group(6):" + m.group(6));
			
			if(m.group(1).equals(m.group(5))){
				s = s.replace(m.group(), m.group(1));
			}
			
		}

		System.out.println("捕获个数:groupCount()=" + m.groupCount());
		
		
//		System.out.println(s.replaceAll(regex, "$1"));
		System.out.println("\n"+s);
	}
	
	public static void replace(){
		
	}
	
	public static void testSplit() {
		String expr = "\"[\\s]*:[\\s]*[\"\\[]";
		// expr = "\"";
		String line = "\"key1\" : \"value1\", \"key2\" : \"value2\"" + ", \"key3\" : [ \"value31\", \"value32\"]"
				+ ", \"key4\" : [ \"value41\", \"value42\"]";
		Pattern pattern = Pattern.compile(expr);
		Matcher matcher = pattern.matcher(line);
		String[] arr = pattern.split(line);
		System.out.println(matcher);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void testEmail() {
		String email = "joey.jinag@welocalize.com";
		wrapperValidEmail(email);

		email = "joey@welocalize.com";
		wrapperValidEmail(email);

		email = "joey@welocalize";
		wrapperValidEmail(email);

		email = "joey.welocalize";
		wrapperValidEmail(email);
	}

	public static void wrapperValidEmail(String p_email) {
		System.out.print(p_email);
		if (validEmail(p_email)) {
			System.out.print("\t\t is valid.\n");
		} else {
			System.out.print("\t is invalid.\n");
		}
	}

	/**
	 * Validate the email address
	 * 
	 * @param p_mail
	 *            the email address
	 */
	public static boolean validEmail(String p_mail) {

		String expression;
		// expression= email_Expr;
		expression = null;

		return validValueByExpression(p_mail, expression);
	}

	/**
	 * Validate the value by the regular expression.
	 * 
	 * @param p_value
	 *            the value need to be validate by expression
	 * @param p_expr
	 *            regular expression
	 */
	public static boolean validValueByExpression(String p_value, String p_expr) {
		boolean result = false;

		if (p_value == null || p_expr == null) {
			return false;
		}

		CharSequence inputStr = p_value;
		Pattern pattern = Pattern.compile(p_expr);
		// Make the comparison case-insensitive.
		// Pattern pattern =
		// Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			result = true;
		}
		return result;
	}

}
