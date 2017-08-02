package com;

public class Runner {

	static int i = 0;

	/**
	 * 无同步方法
	 */
	public void noSync(long threadId) {
		System.out.println("无锁\t" + threadId);
	}

	/**
	 * 对象级同步方法_1
	 */
	synchronized public void objectSync_1() {
		System.err.println("对象锁\tobjectSync_1 BEGIN");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象锁\tobjectSync_1 END");
	}

	/**
	 * 对象级同步方法_2
	 */
	synchronized public void objectSync_2() {
		System.err.println("对象锁\tobjectSync_2 BEGIN");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象锁\tobjectSync_2 END");
	}

	/**
	 * 类级同步方法
	 */
	public void classSync() {
		synchronized (this.getClass()) {
			System.out.println("类锁\t" + i);
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}
