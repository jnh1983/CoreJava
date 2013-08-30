package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		int cpuCoreNumber = Runtime.getRuntime().availableProcessors(); 
		System.out.println(Thread.activeCount());
        ExecutorService exec = Executors.newFixedThreadPool(cpuCoreNumber); 
//        exec.submit(new Task());
        
        System.out.println("CPU Account:" + cpuCoreNumber);
        System.out.println(Thread.activeCount());
	}

}

class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("2222");
	}
}
