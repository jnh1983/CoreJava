package com.test.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Date now = Calendar.getInstance().getTime();
		print(now);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("10/06/2012");
		print(date);
		Date date1 = new Timestamp(1339257600000l);
		print(date1);
	}

	public static void print(Date p_date) {
		System.out.println(p_date + "\t" + (p_date.getYear() - 100) + "/" + (p_date.getMonth() + 1) + "/"
				+ p_date.getDate() + "\t\t" + p_date.getTime()+ "\t" + p_date.getTimezoneOffset());
	}

}
