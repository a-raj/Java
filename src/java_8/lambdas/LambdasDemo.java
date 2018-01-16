package java_8.lambdas;


public class LambdasDemo {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Another thread");
				
			}
		});
		
		thread.start();
		
		System.out.println("Inside main");
		
		
		/*
		 * With Lambda you required only function parameter and and body no name and return type
		 * Compare it with above thread where we were using anonymous class
		 * Here name became anonymous and return type inferred
		 * 
		 * */

		Thread thread2 = new Thread(() -> System.out.println("Lambda thread"));
		thread2.start();
	}
	
	
	
}
