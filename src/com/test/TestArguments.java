package com.test;

public class TestArguments {

	/**
	 * @aa bb cc
	 */
	public static void main(String[] args) {
		if(args.length<1){
			System.out.println("There is no input.");
		}else{
			for(int i=0;i<args.length;i++){
				System.out.print(args[i]+"###");
			}
		}

	}

}
