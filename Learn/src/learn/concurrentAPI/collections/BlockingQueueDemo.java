package learn.concurrentAPI.collections;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * ArrayBlockingQueue
		 * Its size can't be changed in future
		 * */
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(50);
		blockingQueue.addAll(Arrays.asList("One", "Two", "Three"));
		blockingQueue.forEach(System.out::println);

		
		/*
		 * DelayQueue
		 * The DelayQueue blocks the elements internally until a certain delay has expired.
		 * */
		DelayQueue<Delayed> delayQueue = new DelayQueue<>();
		Delayed delayElement1 = new DelayElement(UUID.randomUUID().toString(), 1000L);
		delayQueue.put(delayElement1);
		
		
		/*
		 * LinkedBlockingQueue
		 * The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes).
		 * If no upper bound is defined then Integer.MAX_VALUE will be the upper bound
		 * */
		BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(1000);
		linkedBlockingQueue.put("test");
		String value = linkedBlockingQueue.take();
		System.out.println(value);
		
		
		/*
		 * PriorityBlockingQueue
		 * Same as PriorityQueue
		 * Priority is decided on the basis of Natural ordering or Comparator provided in constructor   
		 * */
		BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>(10);
		priorityBlockingQueue.put("TEST");
		
		
		/*
		 * SynchronousQueue 
		 * Each insert operation must wait for a corresponding remove operation by another thread, and vice versa.
		 * */
		BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
		synchronousQueue.put("Someone other Thread is waithing to remove me!");
		
		
		
	}
}

class DelayElement implements Delayed{
	private String date;
	private long startTime;
	
	public DelayElement(String date, long startTime) {
		this.date = date;
		this.startTime = startTime;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if(this.startTime < ((DelayElement) o).startTime){
			return -1;
		}
		if(this.startTime > ((DelayElement) o).startTime){
			return 1;
		}
		return 0;
	}
}
