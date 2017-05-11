package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		int numberOfTasks = 10;
		int threadPoolSize = 5;
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
		
		TaskThread[] tasks = new TaskThread[numberOfTasks];
		
		for(int i = 0; i < numberOfTasks; i++){
			tasks[i] = new TaskThread(i);
			executorService.execute(tasks[i]);
		}
		
		executorService.shutdown();
	}
}
