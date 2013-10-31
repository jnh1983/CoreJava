package com.test.collection.queue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue q = new ArrayBlockingQueue(10);
//		Producer p = new Producer(q);
//		Consumer c1 = new Consumer(q);
//		Consumer c2 = new Consumer(q);
//		new Thread(p).start();
//		new Thread(c1).start();
//		new Thread(c2).start();
		
		/**/
		ExecutorService service = Executors.newCachedThreadPool();
		int max = 3;
		for (int i = 0; i < max; i++) {
			service.execute(new Producer(q));
		}
		for (int i = 0; i < max; i++) {
			service.execute(new Consumer(q));
		}
		
	}

}

class Producer implements Runnable {
	private final BlockingQueue queue;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private final String basic = "ChanPin";

	Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
//				synchronized
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
			System.out.println(Thread.currentThread() + "\tProducer run error, " + ex);
		}
	}

	Object produce() throws InterruptedException {
		String value = basic + "[" + sdf.format(new Date()) + "]";
		System.out.println(Thread.currentThread() + "\t$$$Producing..." + value + "\t" + queue.size());
		Thread.sleep(1000);
		return new String(value);
	}
}

class Consumer implements Runnable {
	private final BlockingQueue queue;

	Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				consume(queue.take());
			}
		} catch (InterruptedException ex) {
			System.out.println(Thread.currentThread() + "\tConsumer run error, " + ex);
		}
	}

	void consume(Object x) {
		System.out.println(Thread.currentThread() + "\t***Consuming..." + x + "\t" + queue.size());
	}
}