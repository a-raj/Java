package concurrentClasses.callable;

import java.util.concurrent.*;

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


	static class Factorial implements Callable<Integer> {

		private int n;
		Factorial(int n){
			this.n = n;
		}

		@Override
		public Integer call() throws Exception {
			int fact = 1;
			for(int i = 2; i <=n; i++ ) {
				fact *= i;
			}
			return fact;
		}
	}


	static class Sum implements Callable<Integer> {

		private int n;

		Sum(int n){
			this.n = n;
		}
		@Override
		public Integer call() throws Exception {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum+=i;
			}
			return sum;
		}
	}
}
