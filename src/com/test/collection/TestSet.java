package com.test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSet t = new TestSet();
		 tString();
		t.tStudent();
	}

	public static void tString() {
		String str;
		Set set = new HashSet();
		str = set.toString();
		System.out.println(set + "\t" + set.size() + "\t" + str + "\t" + str.substring(1, str.length() - 1));
		
		set.add("set1");
		set.add("set2");
		set.add("set1");

		str = set.toString();
		System.out.println(set + "\t" + set.size() + "\t" + str + "\t" + str.substring(1, str.length() - 1));

		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("a");
		System.out.println(list);
	}

	public void tStudent() {
		Set set = new HashSet();
		Student s = new Student(1L, "stu1", "");
		Student s1 = new Student(1L, "stu1", "");
		set.add(s);
		set.add(s1);

		System.out.println(set.size() + "\t" + set);
	}

	public class Student {

		Long id;
		String name, desc;

		Student() {
		}

		Student(Long id, String name, String desc) {
			this.id = id;
			this.name = name;
			this.desc = desc;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		@Override
		public String toString() {
			return "[id=" + id + ", name=" + name + ",desc=" + desc + "]\t";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((desc == null) ? 0 : desc.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (desc == null) {
				if (other.desc != null)
					return false;
			} else if (!desc.equals(other.desc))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private TestSet getOuterType() {
			return TestSet.this;
		}

	}

}
