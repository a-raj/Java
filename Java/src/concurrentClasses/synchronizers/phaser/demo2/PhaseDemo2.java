package concurrentClasses.synchronizers.phaser.demo2;

public class PhaseDemo2 {
	
	public static void main(String[] args) {
		
		MyPhaser myPhaser = new MyPhaser(1, 4);
		
		System.out.println("Stating");
		MyThread2 myThread1  = new MyThread2(myPhaser, "A");
		MyThread2 myThread2  = new MyThread2(myPhaser, "B");
		MyThread2 myThread3  = new MyThread2(myPhaser, "C");
		
		
		(new Thread(myThread1)).start();
		(new Thread(myThread2)).start();
		(new Thread(myThread3)).start();
		
		while(!myPhaser.isTerminated()) {
			myPhaser.arriveAndAwaitAdvance();
		}
		System.out.println("The phaser is terminated");
	}
 
}
