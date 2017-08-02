package com;

public class Util {

	public static void main(String[] args) {
//		simpleTest();
//		oneObjectToOneThread();
		oneObjectToMultThread();
	}
	
	/**
	 * 简单测试两种线程类的实现方法
	 */
	public static void simpleTest(){
		Thread threadTest = new ThreadTest();  //初始化继承实例，既有run又有start方法
		threadTest.start();  //只有调用start方法才是以线程方式调用run逻辑
		
		RunnableTest runnableTest = new RunnableTest();  //初始化实现实例，只有run方法，没有start方法
		Thread tmpThread = new Thread(runnableTest);  //初始化线程实例，并将实现实例作为【构造参数】传进去
		tmpThread.start();  //由于实现式没有start方法来启动线程，所以必须将其传递给一个线程类对象，才能调用外层对象来启动线程
	}
	
	/**
	 * 一个对象对应单个线程
	 */
	public static void oneObjectToOneThread(){
		for(int i = 0; i < 10; i++){
			Runner runner = new Runner();
			ThreadTest threadTest = new ThreadTest(runner, i);
			threadTest.start();
		}
	}
	
	/**
	 * 一个对象对应多个线程
	 */
	public static void oneObjectToMultThread(){
		Runner runner = new Runner();
		for(int i = 0; i < 10; i++){
			ThreadTest threadTest = new ThreadTest(runner, i);
			threadTest.start();
		}
	}

}
