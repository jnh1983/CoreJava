package com.test;

public class TestSuper {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void print(){
		System.out.println("Super:" + getMsg());
	}

}
