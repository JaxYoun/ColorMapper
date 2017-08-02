package com.synclock;

public class Util {

	public static void main(String[] args) {
//		objectLockTest();
//		oneToOneTest();
		classLock();
	}
	
	/**
	 * 多个线程公用同一对象，并调用对象的加锁方法，会导致对象被锁，
	 * 持有对象锁的线程才能调用对象的方法，其他线程只能阻塞
	 */
	public static void objectLockTest(){
		Actor actor = new Actor();
		
		ThreadA a = new ThreadA(actor);
		ThreadB b = new ThreadB(actor);
		ThreadC c = new ThreadC(actor);
		
		a.start();
		b.start();
		c.start();
	}
	
	/**
	 * 多个线程公持有各自的对象，并调用对象的加锁方法，不会导致对象被锁，
	 * 由于各个线程独占各自的对象锁，线程能顺利调用各自对象的方法，个线程并行执行
	 */
	public static void oneToOneTest(){
		Actor actorA = new Actor();
		Actor actorB = new Actor();
		Actor actorC = new Actor();
		
		ThreadA a = new ThreadA(actorA);
		ThreadB b = new ThreadB(actorB);
		ThreadC c = new ThreadC(actorC);
		
		a.start();
		b.start();
		c.start();
	}
	
	/**
	 * 
	 */
	public static void classLock(){
		Actor actorA = new Actor();
		Actor actorB = new Actor();
		Actor actorC = new Actor();
		Actor actorD = new Actor();
		
		ThreadA a = new ThreadA(actorA);
		ThreadB b = new ThreadB(actorB);
		ThreadC c = new ThreadC(actorC);
		ThreadD d = new ThreadD(actorD);
		
		d.start();
		a.start();
		b.start();
		c.start();
	}
}
