package com.test.vo;

import java.util.Map;

public class PersonFactory {
	public static final String TYPE_STUDENT = "Student";
	public static final String TYPE_TEACHER = "Teacher";
	
	public static Object getPerson(String p_personType, Map p_dataMap){
		if(TYPE_STUDENT.equals(p_personType)){
			return new Student(-1, "NameFactory", -1);
		}
		
		return null;			
	}
}
