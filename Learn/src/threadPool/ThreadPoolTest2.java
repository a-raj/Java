package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class to test {@link CallableTaskThread}<br>
 * 
 * ThreadPoolTest2 uses the CachedThreadPool executor service which creates as many threads as needed but reuses previously constructed threads if available.<br> 
 * We use the submit method to ask an executor service to run a {@link Callable}. This method returns a {@link Future} object which gives you control over the task;<br> 
 * we can use the Future to retrieve the result of running the task, monitor the task, and cancel the task.
 * */
public class ThreadPoolTest2 {

	public static void main(String[] args) {
		int numberOfTask = 5;
		ExecutorService executorService = Executors.newCachedThreadPool();
		CallableTaskThread tasks[] = new CallableTaskThread[numberOfTask];
		
		//Future futures[] = new Future[numberOfTask];
		@SuppressWarnings("rawtypes")
		List<Future> futures = new ArrayList<Future>(numberOfTask);
		
		for(int i = 0; i < numberOfTask; i++){
			tasks[i] = new CallableTaskThread(i);
			futures.add(executorService.submit(tasks[i]));
		}
		
		for(int i = 0; i < numberOfTask; i++){
			try{
				System.out.println("Ending task: " + futures.get(i).get());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
