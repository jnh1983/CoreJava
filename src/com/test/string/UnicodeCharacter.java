package com.test.string;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class UnicodeCharacter {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String text = "mšk žilinaä";
	String normalized = removeDiacriticalMarks(text);
	System.out.println(normalized); // msk zilina
	
//	System.out.println(asHex("a"));
	normalizerTest();
    }
    
    public static String removeDiacriticalMarks(String string) {
	    return Normalizer.normalize(string, Form.NFD)
	        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

    public static void normalizerTest() {
	String original = "aáeéiíoóöőuúüű AÁEÉIÍOÓÖŐUÚÜŰ 中国";
	for (int i = 0; i < original.length(); i++) {
	    // we will report on each separate character, to show you how this
	    // works
	    String text = original.substring(i, i + 1);
	    // normalizing
	    String decomposed = Normalizer.normalize(text, Form.NFD);
	    // removing diacritics
	    String removed = decomposed.replaceAll(
		    "\\p{InCombiningDiacriticalMarks}+", "");

	    // checking the inside content
	    System.out.println(text + " (" + asHex(text) + ") \t-> " + decomposed
		    + " (" + asHex(decomposed) + ") \t-> " + removed + " ("
		    + asHex(removed) + ")");
	}
    }
    
    public static String asHex(String p_str){
	char[] arr = p_str.toCharArray();
	String result = "";
	for(char c : arr){
	    String temp = Integer.toHexString((int)c);
	    if(temp.length() == 2){
		temp = "00" + temp;
	    }else if(temp.length() == 3){
		temp = "0" + temp;
	    }
	    result = result + temp + " ";
	}
	
	if(result.length()==5){
	    result += "     ";
	}
	return result;
    }
}
