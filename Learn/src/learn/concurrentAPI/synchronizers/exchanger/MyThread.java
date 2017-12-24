package learn.concurrentAPI.synchronizers.exchanger;

import java.util.concurrent.Exchanger;

public class MyThread extends Thread{
	
	Exchanger<String> exchanger;
	String message;
	
	MyThread(Exchanger<String> exchanger, String message) {
	      this.exchanger = exchanger;
	      this.message = message;
	}
	
	public void run() {
		try {
			System.out.println(this.getName() + " message: " + message);
			
			//Exchange message with the other thread 
			message = exchanger.exchange(message);
			Thread.sleep(1000);
			System.out.println(this.getName() + " message: " + message);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}