package com.test.regex;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.globalsight.ling.common.XmlEntities;

public class Test0 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Test0 test = new Test0();

	// testGroup();
	testSplit(null);
    }

    /**
     * 以非字母和数字作为分隔符，输出数据
     * 
     * @param input
     */
    public static void testSplit(String input) {
	// \p{name}: 一个指定的字符类
	// Punct :非字母或数字ASCII [\p{Print}&&\P{Alnum}]
	Pattern pattern = Pattern.compile("\\s*\\p{Punct}\\s*");
	if (input == null || input == "") {
	    input = "begin | test { split 123456 }00end";
	}
	String[] tokens = pattern.split(input);
	for (String str : tokens) {
	    System.out.println(str);
	}
    }

    /**
     * in:给定模式((1?[0-9]):([0-5][0-9]))[ap]m，并且输入11:59am out:Match ((11):(59))am
     */
    public static void testGroupMatch() {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter pattern: ");
	String patternString = in.nextLine();

	Pattern pattern = null;
	try {
	    pattern = Pattern.compile(patternString);
	} catch (PatternSyntaxException e) {
	    System.out.println("Pattern syntax error");
	    System.exit(1);
	}

	while (true) {
	    System.out.println("Enter string to match: ");
	    String input = in.nextLine();
	    if (input == null || input.equals(""))
		return;
	    Matcher matcher = pattern.matcher(input);
	    if (matcher.matches()) {
		System.out.println("Match!");
		int g = matcher.groupCount();// 获得总的分组数
		if (g > 0) {
		    for (int i = 0; i < input.length(); i++) {
			for (int j = 1; j <= g; j++) {// 第0个分组代表所有的分组，第一个实际分组的索引是1。
			    if (i == matcher.start(j)) {// 此位置是分组的起始
				System.out.print('(');
			    }
			}
			System.out.print(input.charAt(i));
			for (int j = 1; j <= g; j++) {
			    if (i + 1 == matcher.end(j)) {// 下一个位置是分组的结束
				System.out.print(')');
			    }
			}
		    }
		    System.out.println();
		}
	    } else
		System.out.println("No match");
	}
    }

    /**
     * This program displays all URLs in a web page by matching a regular
     * expression that describes the <a href=...> HTML tag.
     * 
     * @param urlString
     */
    public static void testHrefMatch(String urlString) {
	if (urlString == null || urlString == "") {
	    urlString = "http://java.sun.com";
	}
	try {
	    InputStreamReader in = new InputStreamReader(new URL(urlString)
		    .openStream());
	    StringBuilder input = new StringBuilder();
	    int ch;
	    while ((ch = in.read()) != -1) {
		input.append((char) ch);
	    }
	    String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>])\\s*>";
	    Pattern pattern = Pattern.compile(patternString,
		    Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(input);
	    while (matcher.find()) {
		int start = matcher.start();
		int end = matcher.end();
		String match = input.substring(start, end);
		System.out.println(match);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void testGroup() {
	String exprex = "a(?>b|bc)m";
	String data = "abcmkfabm";
	System.out.println("Data: " + data + "\tExpression: " + exprex);
	Pattern pattern = Pattern.compile(exprex);
	Matcher m = pattern.matcher(data);
	while (m.find()) {
	    System.out.println(m.group());
	}

	exprex = "a(?:b|bc)m";
	System.out.println("\nData: " + data + "\tExpression: " + exprex);
	pattern = Pattern.compile(exprex);
	m = pattern.matcher(data);
	while (m.find()) {
	    System.out.println(m.group());
	}

    }

    /**
     * Transfer tags into inline tags with &lt;ph&gt;
     * 
     * @param string
     *            the String content of the file
     * @param tagType
     * @param newline
     *            whether the end contains a \n
     * @return
     */
    private String handleInlineTag(String string, String tagType,
	    boolean newline) {
	int index = 1;
	StringBuffer stuff = new StringBuffer();
	XmlEntities m_xmlEncoder = new XmlEntities();
	stuff.append("<ph type=\"" + tagType + "\" id=\"" + index + "\" x=\""
		+ index++ + "\">");
	stuff.append(m_xmlEncoder.encodeStringBasic(string));
	if (newline) {
	    stuff.append("\n");
	}
	stuff.append("</ph>");
	return stuff.toString();
    }
}
