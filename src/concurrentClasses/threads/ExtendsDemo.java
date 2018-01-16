package concurrentClasses.threads;


/**
 * What happens when you directly call run method for a thread?
 * 
 * Invoking the run method in the current thread, the method would goes into the current thread stack, 
 * rather than the beginning of the new stack( which happens when you call the start method )
 * */
public class ExtendsDemo extends Thread {

	
	public void run(){
		try{
			for(int i = 1; i < 6; i++){
				System.out.println("Inside for " + i + " Thread name " + this.getName());
				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExtendsDemo extends1 = new ExtendsDemo();
		ExtendsDemo extends12 = new 	ExtendsDemo();
		
		
		 
		
		//Use either of the below to see what happens
		extends1.start();
		extends12.start();
		
		
		/*
		extends1.run();
		extends12.run();
		*/
	}

}
