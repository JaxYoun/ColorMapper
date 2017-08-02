package com.synclock;

/**
 * 本类中的三个方法[A-C]用的全是对象同步锁
 * @author youn
 *
 */
public class Actor {
	
	synchronized public void methodA(){
		for(int i = 0; i < 10; i++){
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("methodA");
		}
	}
	
	public void methodB(){
		synchronized(this){
			for(int i = 0; i < 10; i++){
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("methodB");
			}
		}
	}
	
	synchronized public void methodC(){
		for(int i = 0; i < 10; i++){
			System.out.println("methodC");
		}
	}
	
	public void methodD(){
		synchronized (this.getClass()) {
			for(int i = 0; i < 10; i++){
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("methodD");
			}
		}
	}
	
}
