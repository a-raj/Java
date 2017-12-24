package learn.concurrentAPI.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class PersonCrossingBridge implements Runnable{

	private String name;
	private Semaphore semaphore;
	
	public PersonCrossingBridge(String name, Semaphore semaphore) {
		super();
		this.name = name;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		 System.out.println(this.name + " is on the line");
		 
		try {
			System.out.println( this.name + " is waiting for permit");

			semaphore.acquire();
			System.out.println(this.name + " gets the permit");
			//now access the share resource (Bridge)
			Bridge.presentCount++;
			
			for(int i = 1; i <= 10; i++) {
				System.out.println(this.name + " covers " + 10*i + "% distance");
				Thread.sleep(500);
			}
			System.out.println("present count on bridge " + Bridge.presentCount);
			
			//Let the person sleep for a few second, so that we can check if context switching is possible (Not allowed)
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			//releasing resource
			semaphore.release();
			Bridge.presentCount--;
			System.out.println(this.name + " successfully cross the bridge Present count on the bridge " + Bridge.presentCount);
		}
	}
}
