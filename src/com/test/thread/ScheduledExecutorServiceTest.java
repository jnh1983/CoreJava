package com.test.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
	
	public static void main(String[] args) {
		test();
//		testScheduleAtFixedRate();
	}
	
	public static void test(){
		String msg = "schedule Test ";
		ScheduledExecutorService threadsPool = Executors.newScheduledThreadPool(5);
		System.out.println("\t\t\t\t\t\t" + getCurrentTime());
		for (int i = 0; i < 1; i++) {
			threadsPool.schedule((Callable)new Task(msg + i + "\t\t"), 2l, TimeUnit.SECONDS);
		}
	}
	
	public static void testScheduleAtFixedRate(){
		String msg = "scheduleAtFixedRate Test ";
		ScheduledExecutorService threadsPool = Executors.newScheduledThreadPool(5);
		System.out.println("\t\t\t\t\t\t" + getCurrentTime());
		for (int i = 0; i < 1; i++) {
			threadsPool.scheduleAtFixedRate(new Task(msg + i), 2l, 3L, TimeUnit.SECONDS);
		}
	}
	
	public static String getCurrentTime(){
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
		return sdf.format(date);
	}
}

class Task implements Callable<String>, Runnable{

	java.lang.String msg = "This is Callable Task!";
	
	public Task(String msg) {
		this.msg = msg;
	}

	@Override
	public String call(){
		System.out.println(msg + "\t\t\t" 
				+ ScheduledExecutorServiceTest.getCurrentTime());
		return msg;
	}

	@Override
	public void run() {
		call();
	}
}
