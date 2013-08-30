package com.test.object;

public class Person {

    private int id;
    private String name;
    
    Person(int p_num, String p_name) {
	id = p_num;
	name = p_name;
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

}
