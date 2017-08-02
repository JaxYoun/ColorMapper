package com.synclock;

public class ThreadB extends Thread {
	
	private Actor actor;
	
	public ThreadB(Actor act){
		this.actor = act;
	}
	
	@Override
	public void run(){
		actor.methodA();
	}
}
