package learn.concurrentAPI.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(Bridge.MAX_CAPACITY, true);
		
		PersonCrossingBridge personCrossingBridge1 = new PersonCrossingBridge ("Aman", semaphore);
		PersonCrossingBridge personCrossingBridge2 = new PersonCrossingBridge ("Avinash", semaphore);
		PersonCrossingBridge personCrossingBridge3 = new PersonCrossingBridge ("Shiva", semaphore);
		
		new Thread(personCrossingBridge1).start();
		new Thread(personCrossingBridge2).start();
		new Thread(personCrossingBridge3).start();
	}
}
