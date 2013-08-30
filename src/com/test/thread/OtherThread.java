package com.test.thread;

public class OtherThread implements Runnable {
	private int val;

	public OtherThread(int val) {
		this.val = val;
	}

	@Override
	public void run() {
		MyThreadlocal.setThreadLocalNum(val);
		MyThreadlocal.setNum(val);
		for (int i = 0; i < 5; i++) {
			System.out.println("thread " + Thread.currentThread().getId() + "-->" + val + ":"
					+ MyThreadlocal.getThreadLocalNum() + "\t" + MyThreadlocal.getNum());
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
