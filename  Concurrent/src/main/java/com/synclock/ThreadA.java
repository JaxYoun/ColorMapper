package com.synclock;

public class ThreadA extends Thread {

	private Actor actor;
	
	public ThreadA(Actor act){
		this.actor = act;
	}
	
	@Override
	public void run(){
		actor.methodB();
	}
}
