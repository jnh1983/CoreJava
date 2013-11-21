package com.test.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}

}

class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			System.out.println("Waiter 1111111");
			latch.await();
			System.out.println("Waiter 2222222");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("Decrementer 1111111");

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("Decrementer 2222222");

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("Decrementer 3333333");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}