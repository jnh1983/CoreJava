package com.test.syntax;

/**
 * @author yubing.linyb 
 * 2009.7.29 
 * 测试枚举类型WeekDay.
 */
public class WeekDayTest {
	
	public static void main(String args[]) {
		for (WeekDay day : WeekDay.values()) {
			System.out.println(day + "====>" + day.getDescription());
		}
		WeekDay.printDay(5);
	}
}
