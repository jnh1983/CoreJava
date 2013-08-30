package com.test.hibernate;

import java.util.Date;

public class Room {

    private int id;
    private String name;
    private String description;
    private String create_by;
    private Date create_date;
    private String update_by;
    private Date update_date;

    public Room() {
    }

    public Room(int id, String name) {
	this.id = id;
	this.name = name;
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

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String createBy) {
        create_by = createBy;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date createDate) {
        create_date = createDate;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String updateBy) {
        update_by = updateBy;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date updateDate) {
        update_date = updateDate;
    }

    public String toString() {
	return "ID:" + id + "\tName:" + name;
    }
}
