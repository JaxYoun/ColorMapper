package com.synclock;

public class ThreadC extends Thread {
	
	private Actor actor;
	
	public ThreadC(Actor act){
		this.actor = act;
	}
	
	@Override
	public void run(){
		actor.methodC();
	}
}
