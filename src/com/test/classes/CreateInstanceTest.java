package com.test.classes;

import com.test.vo.PersonFactory;
import com.test.vo.Student;


/**
 * This test class is used for Creating Object Instance.
 * 
 * https://github.com/jnh1983/CoreJava/blob/master/src/com/test/classes/CreateInstanceTest.java
 * 
 * @author Joey
 */
public class CreateInstanceTest {

	public static void main(String[] args) throws Exception{
		// 1. Normal
		Student stu1 = new Student(1, "NameNornal", 1);
		print(stu1);
		
		// 2. Reflection
		Student stu2 = (Student) Class.forName("com.test.vo.Student")
				.getConstructor(Integer.TYPE, String.class, Integer.TYPE)
				.newInstance(2, "NameReflection", 1);
		print(stu2);
		
		// 3. Factory Pattern
		Student stu3 = (Student) PersonFactory.getPerson(PersonFactory.TYPE_STUDENT, null);
		print(stu3);
		
		// 4. Object Clone Method
		Student stu4 = stu1.clone();
		print(stu4);
	}

	public static void print(Student p_stu){
		System.out.println(p_stu);
	}
}
