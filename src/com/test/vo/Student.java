package com.test.vo;

public class Student {

	int id;
	String name;
	int classId;
	
	public Student(){}
	
	public Student(int id){
		this(id, "name" + id, -1);
	}
	public Student(int id, String name) {
		this(id, name, -1);
	}
	
	public Student(int id, String name, int classId) {
		this.id = id;
		this.name = name;
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classId=" + classId + "]";
	}
	
	public Student clone() {
		return new Student(0, "Clone-" + this.name, this.classId);
	}
}
