package com.test.collection.queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {
	public static void main(String[] args) throws InterruptedException {
		// 队列
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		// 生产者一号
		Producer01 producer = new Producer01(queue);
		// 生产者二号
		Producer01 producer2 = new Producer01(queue);
		// 消费者
		Consumer01 consumer = new Consumer01(queue);

		Thread t;
		for (int i = 0; i < 15; i++) {
			t = new Thread(producer);
			t.setName("PA" + getFormatNum(i));
			t.start();
		}

		for (int i = 0; i < 15; i++) {
			t = new Thread(producer2);
			t.setName("PB" + getFormatNum(i));
			t.start();
		}

		for (int i = 0; i < 30; i++) {
			t = new Thread(consumer);
			t.setName("CA" + getFormatNum(i));
			t.start();
		}
	}
	
	public static String getFormatNum(int i) {
		return i < 10 ? "0" + i : "" + i;
	}
}

/**
 * 生产者类，任务是产生个uuid放在队列中
 * 
 * @author Administrator
 * 
 */
class Producer01 implements Runnable {
	private BlockingQueue<String> queue;

	public Producer01(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String uuid = UUID.randomUUID().toString();
		synchronized(queue){
		try {
			queue.put(uuid);
			System.out.println(Thread.currentThread() + "\tproduce uuid:" + uuid + "\tSize:" +queue.size());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		}

	}

}

/**
 * 消费者队列，任务是取得队列中的uuid打印下
 * 
 * @author Administrator
 * 
 */
class Consumer01 implements Runnable {
	private BlockingQueue<String> queue;

	public Consumer01(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		synchronized(queue){
		try {
			String uuid = queue.take();
			System.out.println(Thread.currentThread() + "\tconsume uuid:" + uuid + "\tSize:" +queue.size());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		}

	}
}
