package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testMax();
		// testGetValue();

		// testSimplePut();
//		testPut();
		
		testHashS_Order();

	}

	public static void testSimplePut() {
		Map<String, String> map = new HashMap<String, String>();
		String value = map.get("format");
		System.out.println(value + "\t" + value + "\t" + "value".equals(value));
		map.put("format", "value");
		value = map.get("format");
		System.out.println(value + "\t" + value + "\t" + "value".equals(value));
		map.put("format", "value1");
		value = map.get("format");
		System.out.println(value + "\t" + value + "\t" + "value".equals(value));
	}

	public static void testPut() {
		Map<String, List> map = new HashMap<String, List>();

		List value = map.get("key1");
		System.out.println(value + "\t" + value + "\t" + map.toString());

		value = new ArrayList();
		value.add("file1");
		map.put("key1", value);
		value = map.get("key1");
		System.out.println(value + "\t" + value + "\t" + map.toString());

		value = map.get("key1");
		value.add("file2");
		map.put("key1", value);
		value = map.get("key1");
		System.out.println(value + "\t" + value + "\t" + map.toString());

		value = new ArrayList();
		value.add("file21");
		map.put("key2", value);
		value = map.get("key2");
		System.out.println(value + "\t" + value + "\t" + map.toString());
	}

	public static void testGetValue() {
		// Create a Empty HashMap
		HashMap<String, String> obHashMap = new HashMap<String, String>();
		// Put values in hash map
		obHashMap.put("AB", "1");
		obHashMap.put("EF", "2");
		obHashMap.put("Gh", "3");
		obHashMap.put("CD", "4");
		// Store entry (Key/Value)of HashMap in set
		Set mapSet = (Set) obHashMap.entrySet();
		// Create iterator on Set
		Iterator mapIterator = mapSet.iterator();
		System.out.println("Display the key/value of HashMap.");
		while (mapIterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) mapIterator.next();
			// getKey Method of HashMap access a key of map
			String keyValue = (String) mapEntry.getKey();
			// getValue method returns corresponding key's value
			String value = (String) mapEntry.getValue();

			System.out.println("Key : " + keyValue + "= Value : " + value);
		}

	}

	public static void testMax() {
		Map<String, Integer> map = new HashMap();

		map.put("a", 1);
		map.put("b", 2);
		int maxNum = Collections.max(map.values());
		System.out.println(map + "\t" + map.values() + "\t" + maxNum + "\t" + map);

		map.put("b", -3);
		System.out.println(map + "\t" + map.values());
	}
	
	/*
	 * Test HashMap/HashTable/TreeMap data order.
	 */
	public static void testHashS_Order() {
		Map map = new HashMap();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", "ddd");
		System.out.println("HashMap:\t" + map);
		System.out.println("*******************************");

		Hashtable tab = new Hashtable();
		tab.put("a", "aaa");
		tab.put("b", "bbb");
		tab.put("c", "ccc");
		tab.put("d", "ddd");
		System.out.println("HashTable:\t" + tab);
		System.out.println("*******************************");

		TreeMap tmp = new TreeMap();
		tmp.put("a", "aaa");
		tmp.put("b", "bbb");
		tmp.put("c", "ccc");
		tmp.put("d", "ddd");
		System.out.println("TreeMap:\t" + tmp);
	}

}
