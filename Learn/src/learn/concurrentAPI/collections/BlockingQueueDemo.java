package learn.concurrentAPI.collections;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
	
	public static void main(String[] args) {
		
		//size can't be changed in future
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(50);
		blockingQueue.addAll(Arrays.asList("One", "Two", "Three"));
		
		blockingQueue.forEach(System.out::println);
		DelayQueue<Delayed> delayQueue = new DelayQueue<>();
		
		Delayed delayElement1 = new DelayElement(UUID.randomUUID().toString(), 1000L);
		delayQueue.put(delayElement1);
		
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
