package com.test.concurrency.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Read Write Lock test
 * http://kuchaguangjie.iteye.com/blog/1632154
 * 
 * @author eric
 * @date Aug 14, 2012 10:34:08 PM
 */
public class ReadWriteLockTest {
	private static int i;

	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private static Lock rlk = lock.readLock();
	private static Lock wlk = lock.writeLock();

	private static String data = "";

	private static volatile long lastUpdate; // track last publish date

	/**
	 * publish data, use write lock,
	 * 
	 * @param newData
	 */
	public static void publish(String newData) {
		wlk.lock();
		try {
			printTime("begin publish");
			data = newData;
			lastUpdate = System.currentTimeMillis(); // modify last update date
			printTime("data: [" + data + "]");
			printTime("end publish");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wlk.unlock();
		}
	}

	/**
	 * view data, use read lock
	 * 
	 * @param previousView
	 *            last viewed publish date
	 * @return date of new publish, or -1 if no new publish
	 */
	public static long view(long previousView) {
		if (previousView < lastUpdate) { // new publish
			rlk.lock();
			try {
				printTime("data: [" + data + "]");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rlk.unlock();
			}
			return lastUpdate;
		} else { // no new publish
			printTime("no new publish yet");
			return -1;
		}
	}

	public static void test() throws InterruptedException {
		Thread tPublish = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					publish("hi, xxxxxx, data_" + i + "_xxxxxx");
					try {
						Thread.sleep(1000 * 10); // update interval
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "t-publish");

		// prepare view threads
		int tViewCount = 3; 								// count of view thread
		List<Thread> tViewList = new ArrayList<Thread>();
		final List<Long> tLastView = new ArrayList<Long>(); // keep track of last viewed publish date
		for (int i = 0; i < tViewCount; i++) {
			final int _index = i;
			tViewList.add(new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						long _lastDate = view(tLastView.get(_index));
						if (_lastDate > 0) {
							tLastView.set(_index, _lastDate); // update last viewed publish date, if has new publish
						}
						try {
							Thread.sleep(1000 * 4); // view interval
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}, "t-view-" + i));
			tLastView.add(0L);
		}

		tPublish.start();
		for (int i = 0; i < tViewCount; i++) {
			tViewList.get(i).start();
			Thread.sleep(1000 * 5); // start interval of view threads
		}
	}

	public static void printTime() {
		printTime("");
	}

	/**
	 * print thread name & time
	 * 
	 * @param info
	 *            additional info to print
	 */
	public synchronized static void printTime(String info) {
		System.out.printf("%s:\t%d,\t,%d,\t%s\n", Thread.currentThread().getName(), ++i,
				System.currentTimeMillis() / 1000, info);
	}

	public static void main(String[] args) throws InterruptedException {
		test();
	}
}
