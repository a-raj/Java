package concurrentClasses.callable;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {

	int n;
	
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
