package com.test.thread;

public class TestThreadLocal {
	public static ThreadLocal local = new ThreadLocal();

    public static int getThreadID() {
        return ((Integer) local.get()).intValue();
    }

    public static void setThreadId(int val) {
        local.set(val);
    }

    public static void main(String[] args) {
        System.out.println("main method");
        Thread thread1 = new Thread(new OtherThread(1));
        Thread thread2 = new Thread(new OtherThread(2));
        thread1.start();
        thread2.start();
    }
}
