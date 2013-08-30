package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherGroupParamExample {
    public static void main(String args[]) {
	MatcherGroupParamExample test = new MatcherGroupParamExample();
	test.testGroup();
	
	
    }
    
    public void replaceTag(){
	String regexp1 = "[\\w\\W]*[\\s]*(\\<[\\$]?[\\w\\W]*\\\\>)+[\\s]*[\\w\\W]*";
	
    }
    
    public void testGroup() {
	Pattern p = Pattern.compile("B(ond)");

	String candidateString = "My name is Bond\\x01. James Bond.";

	Matcher matcher = p.matcher(candidateString);

	matcher.find();
	String group_0 = matcher.group(0);
	//String group_1 = matcher.group(1);
	System.out.println("Group 0 " + group_0);
	//System.out.println("Group 1 " + group_1);
	System.out.println(candidateString);

	/*candidateString = "My name is Bond.";
	matcher = p.matcher(candidateString);
	matcher.find();
	group_0 = matcher.group(0);
	group_1 = matcher.group(1);
	System.out.println("Group 0 " + group_0);
	System.out.println("Group 1 " + group_1);
	System.out.println(candidateString);*/
    }
}
