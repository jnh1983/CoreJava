package com.test.hibernate;

public class Student {

    private int id;
    private String name;
    private int roomId;
    
    public Student() {}
    
    public Student(int id, String name, int roomId) {
	super();
	this.id = id;
	this.name = name;
	this.roomId = roomId;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
