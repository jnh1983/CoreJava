package com.test.string;

import java.io.UnsupportedEncodingException;

public class Replace {

    public static void main(String[] args) {
	//normalTest();
	
	String str;	
	str = "initial; background-repeat: initial initial; \">"+
	"<iframe class=\"mqMap\" frameborder=\"0\" height=\"320\" key=\"fWp6\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" src=\"http://www.mapquest.com/embed?icid=mqdist_mb_bs&#38;c=fWp6&#38;maptype=map&#38;zoom=12&#38;center=40.758442,-73.984812\" style=\"display:inline; float:right; margin-left:24px; margin-top:4px;\" width=\"375\"></iframe>On Saturday, the SantaF";


	System.out.println(str + "\n" + str.replaceAll("<iframe[^>]*>(.)*</iframe>","DDD"));
    }

    public static String replaceHTMLEntity(String p_str){
	System.out.println(p_str);
	p_str = p_str.replace("&amp;", "&").replace("&quot;", "\"").replace("&lt;", "<").replace("&gt;", ">");
	System.out.println(p_str);
	
	return p_str;
    }
    
    public static void replaceOrder(String p_str){
	System.out.println(p_str);
	//p_str = p_str.replace("&quot;", "B");
	p_str = p_str.replace("&quot;", "A").replace("&quot;", "B");
	System.out.println(p_str);
    }
    
    public static void normalTest() {
	String str = "aaa\n\r\n\rb'bb";
	System.out.println(str);
	str = str.replace("\n", "NNN");
	str = str.replace("\r", "RRR");
	str = str.replace("'", "&#39;");
	System.out.println(str);

	char[] chars = str.toCharArray();
	for (int i = 0; i < chars.length; i++) {
	    System.out.print(chars[i]);
	}
	System.out.println();
	System.out.print((char) 110);
	System.out.print((char) 46);
	System.out.print((char) 32);
	System.out.print((char) 8233);
	System.out.println("**************");

	/*
	 * char char1 = 'a'; char char2 = '\u2029'; char char3 = 'b'; String
	 * str2 = String.valueOf(char1) + String.valueOf(char2);
	 * System.out.print(str2); System.out.println("**************");
	 */

	char[] char2 = { (char) 110, (char) 110, (char) 46, (char) 32,
		(char) 8233, };
	String str3 = String.valueOf(char2);
	try {
	    str3 = new String(str3.getBytes(), "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println(str3 + "||");
    }
}
