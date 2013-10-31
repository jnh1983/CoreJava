package com.test.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Compare notice()/wait() To Condition.signal()/Condition.await()
 * From: http://my.oschina.net/leoson/blog/106452
 */
public class TestCondition {

	private ReentrantLock lock = null;
	private Condition condition = null;

	public TestCondition() {
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}

	public static void main(String[] args) {
		TestCondition tester = new TestCondition();

		tester.test();
	}

	public void test() {
		new Thread(new WaitThread1(this)).start();
		new Thread(new WaitThread1(this)).start();
		new Thread(new WaitThread1(this)).start();

		new Thread(new NotifyThread1(this)).start();
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public Condition getCondition() {
		return condition;
	}
}

class NotifyThread1 implements Runnable {
	private TestCondition tester = null;

	public NotifyThread1(TestCondition tester) {
		this.tester = tester;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				tester.getLock().lock();
				tester.getCondition().signal();
//				tester.getCondition().signalAll();
				System.out.println(Thread.currentThread() + " condition signal.");
			} finally {
				tester.getLock().unlock();
			}
		}
	}
}

class WaitThread1 implements Runnable {
	private TestCondition tester = null;

	public WaitThread1(TestCondition tester) {
		this.tester = tester;
	}

	public void run() {
		System.out.println(Thread.currentThread() + " started.");

		while (true) {
			tester.getLock().lock();

			try {
				// getCondition().await() 将使getLock()解锁，以便其他线程可以进入 await();
				tester.getCondition().await();

				System.out.println(Thread.currentThread() + " get condition.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				tester.getLock().unlock();
			}
		}
	}
}
