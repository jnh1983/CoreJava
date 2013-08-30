package com.test.l18n;

import java.util.Locale;

public class LocaleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	LocaleTest test = new LocaleTest();
	//test.printLocaleWrapper();
	

	// Create a generic English-speaking locale.
	  
	Locale locale1 = new Locale("en");
	  // Create an English-speaking, Canadian locale.
	  Locale locale2 = new Locale("en", "CA");
	  // Create a very specific English-speaking, U.S. locale
	  // for Silicon Valley.
	  Locale locale3 = new Locale("en", "US", "SiliconValley");
	  
	  /*test.printLocale(locale1);
	  test.printLocale(locale2);
	  test.printLocale(locale3);
	  */

	  /*
	  Locale deLocale = new Locale("de", "DE");
	  Locale frLocale = new Locale("fr", "FR");
	  System.out.println("Default language name (default): " + 
	                      deLocale.getDisplayLanguage());
	  System.out.println("German language name (German): " + 
	                      deLocale.getDisplayLanguage(deLocale));
	  System.out.println("German language name (French): " + 
	                      deLocale.getDisplayLanguage(frLocale));
	  
	  Locale locale = new Locale("de");
	  System.out.println(locale.getLanguage()+ "\t" + locale.getDisplayLanguage());
	   */

	  test.printLocale(Locale.CHINA);
	  test.printLocale("chinese");
    }
    
    public void printLocaleWrapper(){
	printLocale("aaaa");
	printLocale("fr");
	printLocale("French");
	/*
	printLocale("french");
	printLocale("frenCH");
	printLocale("frenCH1");
	*/
	
	
    }
    
    public void printLocale(String language){
	Locale locale = new Locale(language);
	printLocale(locale);
    }
    
    public void printLocale(Locale locale){
	//System.out.println(locale.getLanguage()+"\t"+locale.getDisplayLanguage()+"\t"+locale.getISOLanguages().toString()+"\t"+locale.getISO3Language()+"\t"+locale.toString());
	System.out.println(locale.getLanguage()+"\t"+locale.getDisplayLanguage()+"\t"+locale.toString());
    }

}
