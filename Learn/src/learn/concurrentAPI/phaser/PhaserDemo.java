package learn.concurrentAPI.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		int currentPhase;
		
		System.out.println("Starting");
		
		MyThread thread1 = new MyThread(phaser, "One");
		MyThread thread2 = new MyThread(phaser, "Two");
		MyThread thread3 = new MyThread(phaser, "Three");
		
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		
		phaser.arriveAndDeregister();
		
		if(phaser.isTerminated())
			System.out.println("The phase is terminated");
				
		
		
	}
	
}


