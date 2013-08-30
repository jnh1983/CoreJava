package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList();

		operate(list);
		// removeWrapper(list);

		// sort(list);
		// testIndex();
		testLong();
	}

	public static void testLong(){
		List list = new ArrayList();
		System.out.println("Start:"+list.toString().substring(1, list.toString().length()-1));
		String input = "1,2,55,77,9,2, 1";
		String[] array = input.split(",");
		for(String str : array)
		{
			if(str != null && str.trim().length()>0)
            {
				long id = Long.valueOf(str.trim());
				if(!list.contains(id)){
					list.add(id);
				}
            }
		}
		System.out.println("End:"+list.toString().substring(1, list.toString().length()-1));
	}
	
	public static void testIndex() {
		List nameList = new ArrayList();
		List valueList = new ArrayList();
		String names[] = { "name1", "name2", "name3", "name4", "name5" };
		String values[] = { "value1", "value2", "value3", "value4", "value5" };

		setList(nameList, names);
		setList(valueList, values);

		System.out.println(nameList);
		System.out.println(valueList);

		String name = "name3";
		if (nameList.contains(name)) {
			int i = nameList.indexOf(name);
			System.out.println("!!!Contains " + name + "\tIndex:" + i);

			nameList.remove(i);
			valueList.remove(i);
			System.out.println(nameList);
			System.out.println(valueList);
		}
	}

	public static void setList(List p_list, Object[] p_obj) {
		for (Object obj : p_obj) {
			p_list.add(obj);
		}
	}

	public static void removeWrapper(List<?> list) {
		print(list, 3);
		System.out.println(list.remove(1));
		System.out.println(list.remove("2Joey"));
		print(list, -1);
		System.out.println(list.remove("22Joey"));
		print(list, -1);
	}

	public static void sort(List<String> list) {
		list.add("aa");
		list.add("a1");
		list.add("a2");
		list.add("ba");
		list.add("bb");
		list.add("bA");

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list);
		StringBuffer namesStr = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			namesStr.append(list.get(i)).append("\\r\\n\\");
		}
		System.out.println(namesStr);
	}

	public static void operate(List<String> list) {
		int i = 0;
		String value = "Joey";

		list.add(i++ + "weloc");
		list.add(i++ + "joey@1.com");
		list.add(i++ + value);
		list.add(i++ + value);
		list.add(i++ + value);
		list.add(i++ + value);
		list.add(i++ + value);

		System.out.println(list);
		System.out.println("Get size    :\t  " + list.size());
		int index = 0;
		System.out.println("Get Index " + index + " :\t" + list.get(index));
		index = 1;
		System.out.println("Get Index " + index + " :\t" + list.get(index));
	}

	public static void print(List<?> list, int index) {
		if (index < 0 || index > list.size()) {
			System.out.println(list);
		} else {
			System.out.println(list.get(index));
		}
	}

	public void addTest() {
		String str = "aaa";
		List<String> list = new ArrayList<String>();
		str = "aaa";
		list.add(str);
		str = "bbb";
		list.add(str);
		str = "\n";
		list.add(str);
		str = "ccc";
		list.add(str);

		System.out.println(list);
	}

}
