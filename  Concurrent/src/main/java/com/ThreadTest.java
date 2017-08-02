package com;

public class ThreadTest extends Thread {
	
	private Runner runner;
	private int count;
	
	
	public ThreadTest() {
		super();
	}

	public ThreadTest(Runnable target, String name) {
		super(target, name);
	}

	public ThreadTest(Runnable target) {
		super(target);
	}

	public ThreadTest(String name) {
		super(name);
	}

	public ThreadTest(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
	}

	public ThreadTest(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public ThreadTest(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public ThreadTest(ThreadGroup group, String name) {
		super(group, name);
	}

	public ThreadTest(Runner runer, int i){
		this.runner = runer;
		this.count = i;
	}
	
	public void run(){
//		System.out.println("ThreadTest");
		
		runner.noSync(this.getId());
		if(count % 2 == 0){
			runner.objectSync_2();
		}else{
			runner.objectSync_1();
		}
		runner.classSync();
	}
}
