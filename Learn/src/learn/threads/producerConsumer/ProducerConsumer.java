package learn.threads.producerConsumer;

import java.util.LinkedList;

/**
 * Common class for Producer and Consumer.
 * Producer added items to the list and Consumer remove items from the list.
 * */
public class ProducerConsumer {

	LinkedList<Integer> list = new LinkedList<Integer>();
	int capacaty = 5;
	//Function called by producer thread
	public void produce() throws InterruptedException {
		int value = 0;
		
		while(true){
			//Synchronized block so that only a producer or a consumer thread runs at a time.
			synchronized (this) {
				while(list.size() == capacaty)
					wait();//producer thread waits while list is full
				
				System.out.println("Producer produce-" + value);
				
				list.add(value++);
				//Notify the consumers thread so that it can start consuming
				notify();
				Thread.sleep(2000);
			}
		}
	}
	
	//Function call by consumers thread
	public void consumer() throws InterruptedException{
		
		while(true){
			synchronized (this) {
				//wait while there is nothing to consume
				while(list.isEmpty())
					wait();
				
				System.out.println("Consumer consumed-" + list.removeFirst());
				//Notify the producer that it has consume
				notify();
				Thread.sleep(2000);
			}
		}
	}
	
}
