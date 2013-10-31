package com.test.concurrency.lock;

import java.util.Calendar;

/**
 * Compare notice()/wait() To Condition.signal()/Condition.await()
 * From: http://my.oschina.net/leoson/blog/106452
 */
public class TestWait {

	// 创建event Object，以使用它的wait(), notify()等方法
	private Object event = null;

	public TestWait() {
		// 创建event
		event = new Object();
	}

	public static void main(String[] args) {

		TestWait tester = new TestWait();
		tester.test();
	}

	public Object getEvent() {
		return event;
	}

	public void test() {
		// 启动3个等候线程
		new Thread(new WaitThread(this)).start();
		new Thread(new WaitThread(this)).start();
		new Thread(new WaitThread(this)).start();
		// 启动通知线程
		new Thread(new NotifyThread(this)).start();
	}
}

class WaitThread implements Runnable {
	private TestWait tester = null;

	public WaitThread(TestWait tester) {
		this.tester = tester;
	}

	public void run() {
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTime() + " W " + Thread.currentThread() + " wait for event.");
		while (true) {
			try {
				// 同步访问 event
				synchronized (tester.getEvent()) {
					// 等待在 event 上
					tester.getEvent().wait();
				}
				// 等到 event 后，显示信息 "got event"
				Calendar now1 = Calendar.getInstance();
				System.out.println(now1.getTime() + " W " + Thread.currentThread() + " got event.");

				// do something ...
				Thread.sleep(500);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class NotifyThread implements Runnable {
	private TestWait tester = null;

	public NotifyThread(TestWait tester) {
		this.tester = tester;
	}

	public void run() {
		while (true) {
			try {
				// 间隔1秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 同步访问 event
			synchronized (tester.getEvent()) {
				// 通知等在event上的一个线程
				tester.getEvent().notify();

				// 通知等在event上的所有线程
				// tester.getEvent().notifyAll();
				// 打印 "fire event" 信息。
				Calendar now = Calendar.getInstance();
				System.out.println(now.getTime() + " N " + Thread.currentThread() + " fire event.");
			}
		}
	}
}
