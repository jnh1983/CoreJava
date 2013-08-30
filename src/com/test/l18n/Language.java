package com.test.l18n;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Language {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String str = "リンゴの　リンゴ ひりかな　知事亜";
	System.out.println(str);
	try {
	    str = new String(str.getBytes("8859_1"), "shift_jis");
	} catch (UnsupportedEncodingException e) {}
	System.out.println(str);
	
	
	str = "リンゴ㿮　リンゴ 㿲り㿋㿪　知事亜";
	System.out.println(str);
	try {
	    str = new String(str.getBytes("8859_1"), "Shift_JIS");
	} catch (UnsupportedEncodingException e) {}
	System.out.println(str);
	
	String ss="아/어/여 서, (기) 때문에和(으)니까";
	String ss2="はどれ くらいで すか";
	System.out.println(ss);
	System.out.println("------------------------");
	System.out.println(System.getProperty("file.encoding"));
	System.out.println(ss2);

	try {
	    InputStreamReader isr = new InputStreamReader(new FileInputStream("F:/private/Task/GBS-1727/Eric/tb_export_7.xml"),"windows-31J");

	    BufferedReader bufferedreader = new BufferedReader(isr);

	    String stemp;
	    while ((stemp = bufferedreader.readLine()) != null) {

	                            System.out.println(stemp);

	    } 
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	
    }

}
