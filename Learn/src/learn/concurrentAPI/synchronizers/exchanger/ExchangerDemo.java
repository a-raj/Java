package learn.concurrentAPI.synchronizers.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		
		Thread thread1 = new MyThread(exchanger, "How are You!");
		Thread thread2 = new MyThread(exchanger, "I'm fine what about you!");
		
		thread1.start();
		thread2.start();
	}
	
	
}
