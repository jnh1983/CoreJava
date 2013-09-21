package com.test.collection.map;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyTest {

	public static void main(String[] args) {
		testHashMap();
		testLinkedHashMap();
		testTreeMap();
	}

	public static void testHashMap() {
		Map<String, String> map = new HashMap<String, String>();
		setMapValue(map);
		System.out.println("********* Test HashMap *****************");
		printMap(map);
		
		System.out.println();
	    for(String key : map.keySet())
		{
			System.out.print(key + "[" + key.hashCode() + "], ");
		}
	}

	public static void testLinkedHashMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		setMapValue(map);
		System.out.println("\n********* Test LinkedHashMap *****************");
		printMap(map);
	}

	public static void testTreeMap() {
		Map<String, String> map = new TreeMap<String, String>(
				new Comparator<Object>() {
					Collator collator = Collator.getInstance();

					public int compare(Object o1, Object o2) {
						CollationKey key1 = collator.getCollationKey(o1
								.toString());
						CollationKey key2 = collator.getCollationKey(o2
								.toString());
						return key1.compareTo(key2);
						// return collator.compare(o1, o2);
					}
				});
		setMapValue(map);
		System.out.println("\n********* Test TreeMap *****************");
		printMap(map);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setMapValue(Map p_map) {
		p_map.put("d0", "dd");
		p_map.put("a3", "aa");
		p_map.put("a2", "bb");
		p_map.put("b1", "cc");
		p_map.put("d1", "dc");
		p_map.put("e5", "ba");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void printMap(Map p_map) {
		for (Iterator<String> iterator = p_map.values().iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			System.out.print(name + ", ");
		}
	}
}
