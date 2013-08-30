package com.gs.test.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

    static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
    static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public static void main(String[] args) {
	Date date = new Date();
	
	testFormat(date);
    }
    
    public static void testFormat(Date p_date){
	Date date;
	System.out.println(p_date);
	System.out.println(DateFormat.getDateInstance().format(p_date));
	System.out.println(sdf.format(p_date));
    }

}
