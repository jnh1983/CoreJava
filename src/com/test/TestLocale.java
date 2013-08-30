package com.test;

import java.util.Locale;

public class TestLocale {

    /**
     * @param args
     */
    public static void main(String[] args) {
	testCreateLocale("zh");
	testCreateLocale("zh-CN");
	testCreateLocale("zh-TW");
	testCreateLocale("chr");

	printLocale();
    }
    
    public static void testCreateLocale(String p_lang){
	Locale locale = new Locale(p_lang);
	System.out.println(locale.toString());
    }
    
    public static void printLocale(){
	System.out.println("***Print Locale***");
	System.out.println(Locale.CANADA);
	System.out.println(Locale.CANADA_FRENCH);
	System.out.println(Locale.CHINA);
	System.out.println(Locale.CHINESE);
	System.out.println(Locale.SIMPLIFIED_CHINESE);
	System.out.println(Locale.TRADITIONAL_CHINESE);
	System.out.println(Locale.TAIWAN);
    }

}
