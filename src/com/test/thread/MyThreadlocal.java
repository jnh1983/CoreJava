package com.test.thread;

public class MyThreadlocal {

	static int num;
	static ThreadLocal<Integer> my = new ThreadLocal<Integer>();
	
	public static void setThreadLocalNum(int p_num)
	{
		my.set(p_num);
	}
	
	public static int getThreadLocalNum()
	{
		return my.get();
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		MyThreadlocal.num = num;
	}
}
