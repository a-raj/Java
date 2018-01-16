package concurrentClasses.threads;

public class RunnableDemo implements Runnable{

	Thread thread;
	
	public RunnableDemo(String threadName) {
		thread = new Thread(this, threadName);
		thread.setPriority(10);
		System.out.println("Thread Name " + threadName);
		thread.start();
	} 
	
	@Override
	public void run() {
		try{
			for(int i = 1; i < 6; i++){
				System.out.println("Inside for " + i);
				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new RunnableDemo("Thread 1");
	new RunnableDemo("Thread 2");
	}
	
}
