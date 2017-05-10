package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class to test {@link TaskThread}<br>
 * It uses {@link ExecutorService} to create the thread pool<br>
 * In ThreadPoolTest, we can specify the number of task threads to create and the size of the thread pool that will be used to run the threads. 
 * This example uses a fixed thread pool so that we can observe the effect of running the program with fewer threads than tasks.
 * */
public class ThreadPoolTest {

	public static void main(String[] args) {
		int numberOfTasks = 10;
		int threadPoolSize = 5;
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
		
		
		List<TaskThread> tasks = new ArrayList<TaskThread>(numberOfTasks);
		
		for(int i = 0; i < numberOfTasks; i++){
			tasks.add(new TaskThread(i));
			executorService.execute(tasks.get(i));
		}
		
		executorService.shutdown();
	}
}
