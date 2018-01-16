package concurrentClasses.threads;


public class JoinDemo implements Runnable{
	Thread thread;
	String name;
	
	public JoinDemo(String threadName){
		name = threadName;
		thread = new Thread(this, threadName);
		System.out.println("New thread created " + threadName);
	}

	
	/*
	 * Thread One is interrupted to check
	 * What happens when the thread which calls join method is interrupted
	 * */
	@Override
	public void run() {
		try{
			if(name.equalsIgnoreCase("One"))
				thread.interrupt(); 	 
											
			if(!thread.isInterrupted()){
				for(int i = 1; i < 6; i++){
					System.out.println(name + " " + i);
					Thread.sleep(1000);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JoinDemo joinDemo = new JoinDemo("One");
		JoinDemo joinDemo2 =  new JoinDemo("Two");
		JoinDemo joinDemo3 = new JoinDemo("Three");
		JoinDemo joinDemo4 = new JoinDemo("Four");
		joinDemo.thread.start();
		joinDemo2.thread.start();
		joinDemo4.thread.start();
		
		
		/* 
		 *  join() make sure that the thread in which join is called is stop executing (finishes)
		 *  before the other thread which are called after this thread  
		 * */
		try {
			joinDemo.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		joinDemo3.thread.start();

	}

}
