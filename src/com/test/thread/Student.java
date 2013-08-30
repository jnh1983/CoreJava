package com.test.thread;

public class Student {

	private long id;
	private String name;
	
	public Student(){
		id = -1;
		name = "NULL";
	}
	
	public Student(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		t1.start();
		t2.start();

	}
	
	public static void methodS1() throws InterruptedException{
		System.out.println("methodS1()");
		Thread.sleep(1000);
	}
	
	public static void methodS2() throws InterruptedException{
		System.out.println("methodS2()");
		Thread.sleep(1000);
	}
	
	public void methodA() throws InterruptedException{
		System.out.println("methodA()");
		Thread.sleep(1000);
	}
	
	public void methodB() throws InterruptedException{
		System.out.println("methodB()");
		Thread.sleep(1000);
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
