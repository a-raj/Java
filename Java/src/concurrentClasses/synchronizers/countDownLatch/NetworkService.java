package concurrentClasses.synchronizers.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class NetworkService extends BaseService{

	public NetworkService(CountDownLatch countDownLatch) {
		super("Network Service", countDownLatch);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(2000);
			System.out.println(this.getServiceName() + " is Up");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(this.getServiceName() + " is can't be Up Some thing bad happens");
		}
	}
	
}
