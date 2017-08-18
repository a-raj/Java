package learn.concurrentAPI.phaser.demo2;

import java.util.concurrent.Phaser;

public class MyThread2 implements Runnable {

	Phaser phaser;
	String name;
	
	public MyThread2(Phaser phaser, String name) {
		super();
		this.phaser = phaser;
		this.name = name;
		phaser.register();
	}


	@Override
	public void run() {
		
		while(!phaser.isTerminated()) {
			System.out.println("Thread " + name + " Beginning Phase " + phaser.getPhase());
			phaser.arriveAndAwaitAdvance();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
