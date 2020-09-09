package concurrentClasses.executors;

import java.util.concurrent.*;

public class CallableDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		System.out.println("Starting");
		Future<Integer> sumFuture = executorService.submit(new Sum(100));
		Future<Integer> factorialFuture = executorService.submit(new Factorial(10));

		TimeUnit.SECONDS.sleep(5);
		
		try {
			System.out.println( "Get Called for Sum "+ sumFuture.get());
			System.out.println("Get Called for Factorial "+ factorialFuture.get());
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
			System.out.println("Inside call of Factorial");
			int fact = 1;
			for(int i = 2; i <=n; i++ ) {
				fact *= i;
			}
			System.out.println("call method completed for Factorial");
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
			System.out.println("Inside call of Sum");
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum+=i;
			}
			System.out.println("call method completed for Sum");
			return sum;
		}
	}
}
