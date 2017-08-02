package com.synclock;

public class ThreadD extends Thread {
	
	private Actor actor;
	
	public ThreadD(Actor act){
		this.actor = act;
	}
	
	@Override
	public void run(){
		actor.methodD();
	}
}
