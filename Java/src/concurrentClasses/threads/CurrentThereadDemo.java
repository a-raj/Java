package concurrentClasses.threads;



public class CurrentThereadDemo {
	
	//Controlling the main thread
	public static void main(String[] args) {
		
		Thread thread = Thread.currentThread();
		
		System.out.println(thread.getName() +" priority is " + thread.getPriority());
		
		
		try {
			for(int i = 5; i > 0; i--){
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}

}
