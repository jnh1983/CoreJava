package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTagValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String HTML_TAG_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

    public HTMLTagValidator() {
	pattern = Pattern.compile(HTML_TAG_PATTERN);
    }

    /**
     * Validate html tag with regular expression
     * 
     * @param tag
     *            html tag for validation
     * @return true valid html tag, false invalid html tag
     */
    public boolean validate(String tag) {

	matcher = pattern.matcher(tag);
	return matcher.matches();

    }
    
    public void testValidate(String p_str){
	String b = String.valueOf(validate(p_str)).toUpperCase();
	System.out.println(b+"\t"+p_str);
    }
    
    public static void main(String[] args){
	HTMLTagValidator test = new HTMLTagValidator();
	test.testValidate("Hello");
	test.testValidate("<a>Hello");
	test.testValidate("<a/>Hello");
	test.testValidate("<a>abc</a>");
	test.testValidate("<a>abc<a>");
	test.testValidate("<a>");
    }

}
