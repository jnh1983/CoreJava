package com.test.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {

	public static void main(String[] args) {
		Comparator<String> comparator = new StringLengthComparator();
		PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
		queue.add("short");
		queue.add("very long indeed");
		queue.add("medium");
		System.out.println(queue);
		while (queue.size() != 0) {
			System.out.println(queue.remove());
		}
	}

}
