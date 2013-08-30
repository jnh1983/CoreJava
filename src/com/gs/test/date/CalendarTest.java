package com.gs.test.date;

import java.util.Calendar;

public class CalendarTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	operate();

    }
    
    public static void operate(){
	Calendar cal = Calendar.getInstance();
	System.out.println(cal.getTime());
	cal.add(Calendar.HOUR_OF_DAY, 1);
	System.out.println(cal.getTime());
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println(Calendar.getInstance().getTime());
    }

}
