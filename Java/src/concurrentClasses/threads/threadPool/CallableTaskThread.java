package concurrentClasses.threads.threadPool;

import java.util.concurrent.Callable;


/**
 * 
 * A {@link Callable} is more flexible than a {@link Runnable} because it can return a value and throw an exception.
 * To implement a {@link Callable}, we provide the call method, which returns a value, in this case an Integer that represents the tasks number.
 * */
public class CallableTaskThread implements Callable<Integer> {

	private int taskNumber;
	
	public CallableTaskThread(int taskNumber) {
		this.taskNumber = taskNumber;
	}
	
	@Override
	public Integer call() throws Exception {
		for(int i = 0; i < 100; i+=20){
			System.out.println("Task number " + taskNumber +":  "+ i + "% completed " + " Thread name " + Thread.currentThread().getName());
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		return taskNumber;
	}

}
