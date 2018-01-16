package concurrentClasses.synchronizers.phaser;

import java.util.concurrent.Phaser;

class MyThread  implements Runnable{
	Phaser phaser;
	String name;
	
	MyThread(Phaser phaser, String name){
		this.phaser = phaser;
		this.name = name;
		phaser.register();
		
	}

	@Override
	public void run() {
		System.out.println("Thread " + this.name + " Begginning Phase One");
		phaser.arriveAndAwaitAdvance();

		sleep2Sec();
		
		System.out.println("Thread " + this.name + " Begginning Phase Two");
		phaser.arriveAndAwaitAdvance();

		sleep2Sec();

		System.out.println("Thread " + this.name + " Begginning Phase Three");
		phaser.arriveAndAwaitAdvance();

	}
	
	
	
	private void sleep2Sec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}