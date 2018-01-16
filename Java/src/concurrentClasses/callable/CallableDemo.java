package concurrentClasses.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		System.out.println("Starting");
		Future<Integer> sumFuture = executorService.submit(new Sum(100));
		Future<Integer> factorialFuture = executorService.submit(new Factorial(10));
		
		try {
			System.out.println(sumFuture.get());
			System.out.println(factorialFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		System.out.println("Done");
	}

}
