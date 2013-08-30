package com.test.thread;

import java.util.Calendar;

public class MyThread implements Runnable {

	private String name;
	
	public MyThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(getClass().getName() + "\tstart thread...");
	}
	
	public synchronized void run1(){
		System.out.println(name + ":\t" + Calendar.getInstance().getTime());
	}
	
	public static void main(String[] args){
		printThreadInfo(Thread.currentThread(), "abc");
		Thread t1 = new Thread(new MyThread("MyThr"));
		t1.start();
		printThreadInfo(t1, "abc");
		Thread t2 = new Thread(new MyThread("MyThr"));
		t2.setName("myThread2");
		printThreadInfo(t2, "abc");
	}

	public static void printThreadInfo(Thread p_t, String p_sep){
		String sep = "\r\n";
		if(p_sep == null)
		{
			sep = "";
		}
		
		StringBuffer result = new StringBuffer();
		result.append("[ID:").append(p_t.getId()).append("]").append(sep)
			  .append("[NAME:").append(p_t.getName()).append("]").append(sep)
			  .append("[PRIORITY:").append(p_t.getPriority()).append("]").append(sep)
			  .append("[isAlive:").append(p_t.isAlive()).append("]").append(sep)
			  .append("[isInterrupted:").append(p_t.isInterrupted()).append("]").append(sep)
			  .append("[isDaemon:").append(p_t.isDaemon()).append("]").append(sep);
		
		System.out.println(result.toString());
	}
}
