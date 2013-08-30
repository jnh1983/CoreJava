package com.test;

public class Bike implements Cloneable {

	String type;
	int cost;

	public Bike(String type, int cost) {
		super();
		this.type = type;
		this.cost = cost;
	}

	@Override
	protected Bike clone() throws CloneNotSupportedException {
		return (Bike) super.clone();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Type is " + type + ", Cost is " + cost;
	}

}
