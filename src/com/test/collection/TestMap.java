package com.test.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

import com.test.thread.Student;

public class TestMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testMapsSort();
		testPut();
	}
	
	public static void testPut(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "value1");
		map.put("key2", new Student());
		
		System.out.println(map);
		
		Map<String, Object> data = new HashMap<String, Object>();
		HashSet set = new HashSet<String>();
		set.add("kkTest");
		System.out.println(set);
        data.put("ignoredReceipt", new HashSet<String>().add("kkTest"));
        System.out.println(data);
	}
	
	public static void testMapsSort(){
		Map<String, String> treeMap = new TreeMap<String, String>();
		Map<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("aaa", "aaa");
		hashMap.put("ccc", "ccc");
		hashMap.put("abc", "abc");
		
		treeMap.put("aaa", "aaa");
		treeMap.put("ccc", "ccc");
		treeMap.put("abc", "abc");
		
		System.out.println(hashMap);
		System.out.println(treeMap);
	}

}
