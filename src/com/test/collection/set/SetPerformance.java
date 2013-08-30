package com.test.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * http://www.programcreek.com/2013/03/hashset-vs-treeset-vs-linkedhashset/
 */
public class SetPerformance {

	public static void main(String[] args) {
		Random r = new Random();

		HashSet<Dog> hashSet = new HashSet<Dog>();
		TreeSet<Dog> treeSet = new TreeSet<Dog>();
		LinkedHashSet<Dog> linkedSet = new LinkedHashSet<Dog>();

		// HashSet Part
		long startTime = System.nanoTime();

		for (int i = 0; i < 1000; i++) {
			int x = r.nextInt(1000 - 10) + 10;
			hashSet.add(new Dog(x));
		}
		// end time
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("HashSet:\t" + duration);
		System.out.println("value:\t\t\t" + hashSet);
		System.out.println("Iterator:\t" + (System.nanoTime() - endTime));

		// LinkSet Part
		startTime = System.nanoTime();

		for (int i = 0; i < 1000; i++) {
			int x = r.nextInt(1000 - 10) + 10;
			linkedSet.add(new Dog(x));
		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedHashSet:\t" + duration);
		System.out.println("value:\t\t\t" + linkedSet);
		System.out.println("Iterator:\t" + (System.nanoTime() - endTime));
		

		// TreeSet Part
		startTime = System.nanoTime();

		for (int i = 0; i < 1000; i++) {
			int x = r.nextInt(1000 - 10) + 10;
			treeSet.add(new Dog(x));
		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("TreeSet:\t" + duration);
		System.out.println("value:\t\t\t" + treeSet);
		System.out.println("Iterator:\t" + (System.nanoTime() - endTime));
	}
}

class Dog implements Comparable<Dog> {
	int size;

	public Dog(int s) {
		size = s;
	}

	public String toString() {
		return size + "";
	}

	@Override
	public int compareTo(Dog o) {
		return size - o.size;
	}
}
