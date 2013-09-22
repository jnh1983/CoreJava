package com.test.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.globalsight.ling.docproc.Output;

public class HelloWorld {

	String str;

	private char markQuote = '"';
	private char markColon = ':';
	private char markLeftBracket = '[';

	public static void main(String[] args) {

		HelloWorld test = new HelloWorld();
		String str = "Hello World!!!";
		// test.wrapperAddBlank(str, 3);

		String line = "\"key1\" : \"value1\", \"key2\" : \"value2\"" + ", \"key3\" : [ \"value31\", \"value32\"]"
				+ ", \"key4\" : [ \"value41\", \"value42\"]";

		// test.testJSON(line);

		String regex = "\" : [\"//[]";
		// regex = "\"[\\s]*:[\\s]*[\"\\[][\\s]*[\"]?";
		regex = "\"\\S+\"\\s*:\\s*\"|\"\\S+\"\\s*:\\s*\\[\\s*\"";
		// regex = "\"[\\S]+\"";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		System.out.println(matcher);
		String temp[] = line.split(regex);
		for (String t : temp) {
			System.out.println(t);
		}

		String sub = "ll";
		System.out.println(str + " [" + sub + "] " + str.indexOf(sub) + "\t"
				+ str.substring(str.indexOf(sub) + sub.length()));
		sub = "lll";
		System.out.println(str + " [" + sub + "] " + str.indexOf(sub) + "\t"
				+ str.substring(str.indexOf(sub) + sub.length()));

//		testLowercase();
//		testIndexOf();
		
		System.out.println("startsWith(H):\t" + str.startsWith("H"));
//		System.out.println("startsWith(NULL):\t" + str.startsWith(null));
		
		String path = "D:/GlobalSight/GlobalSight/jboss\\server\\standalone\\deployments\\";
		System.out.println(path.replace("\\", "$"));
	}

	public static void testIndexOf(){
		String str = "Foolish boy.";
		String temp = "Fool";
		System.out.println(str+" IndexOf " + temp +" is:\t" + str.indexOf(temp));
		temp = "fool";
		System.out.println(str+" IndexOf " + temp +" is:\t" + str.indexOf(temp));
	}
	public static void testLowercase() {
		System.out.println("Test Method testLowercase() ---------------------");
		List<String> list = new ArrayList<String>();
		String basicStr = "How are you?";
		list.add(basicStr);
		list.add("HOW ARE YOU?");
		list.add("How äre you?");
		list.add("How are YOU?");
		list.add("How are you?");

		for (String str : list) {
			System.out.println(str + "\t" + str.toLowerCase(Locale.GERMANY) + "\t" + copmareInsensitive(basicStr, str));
		}
	}

	public static boolean copmareInsensitive(String p_str1, String p_str2) {
		return Pattern.compile(Pattern.quote(p_str1), Pattern.CASE_INSENSITIVE).matcher(p_str2).find();
	}

	public void parseLine(Output p_output, String p_line) {

		System.out.println(p_line);

		int indexQuote = -1;
		int indexColon = -1;
		int indexLeftBracket = -1;

		indexQuote = p_line.indexOf(markQuote, indexQuote + 1);
		indexColon = p_line.indexOf(markColon, indexQuote + 1);

		String temp;

		while (indexQuote >= 0 && indexQuote < p_line.length() && indexColon >= 0 && indexColon < p_line.length()) {
			temp = p_line.substring(indexQuote, indexColon);
			if (isSpace(temp)) {
				indexQuote = p_line.indexOf(markQuote, indexColon + 1);
				indexLeftBracket = p_line.indexOf(markLeftBracket, indexColon + 1);

				if (indexQuote < indexLeftBracket) {
					temp = p_line.substring(indexColon, indexQuote);
					if (isSpace(temp)) {
						p_output.addSkeleton(p_line.substring(0, indexQuote));
					}
				} else if (indexQuote < indexLeftBracket) {
					temp = p_line.substring(indexColon, indexLeftBracket);
				}

				char tempChar = getNextNoSpace(p_line, indexColon + 1);
				if (tempChar == markQuote) {
					p_output.addSkeleton(p_line.substring(0, indexColon));
				} else if (tempChar == markLeftBracket) {
					tempChar = getNextNoSpace(p_line, indexColon + 1);
					// if(tempChar == markQuote)
				} else {

				}
			}

			indexQuote = p_line.indexOf(markQuote, indexQuote + 1);
			indexColon = p_line.indexOf(markColon, indexQuote + 1);
		}
	}

	// When the string only contain space, return true
	public boolean isSpace(String p_str) {
		if (p_str.trim().length() == 0 && !p_str.contains("\t") && !p_str.contains("\f") && !p_str.contains("\r")
				&& !p_str.contains("\n")) {
			return true;
		}
		return false;
	}

	public char getNextNoSpace(String p_str, int p_index) {
		char c;
		while (p_index >= 0 && p_index < p_str.length()) {
			c = p_str.charAt(p_index++);
			if (' ' != c) {
				return c;
			}
		}

		return 'N';
	}

	public void wrapperAddBlank(String str, int blanlNum) {
		System.out.println(str);
		System.out.println(addBlank(str, 1));
		System.out.println(str);
	}

	public String addBlank(String str, int blankNum) {
		String blankStr = "";
		for (int i = 0; i < blankNum; i++) {
			blankStr = blankStr + " ";
		}
		return blankStr + str;
	}

	public String operateStr(String str) {
		setStr(str);
		return getStr();
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

}
