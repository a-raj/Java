package learn.concurrentAPI.countDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class BaseService implements Runnable{
	
	private String serviceName;
	private CountDownLatch countDownLatch;
	private boolean serviceUp;
	
	public BaseService(String serviceName, CountDownLatch countDownLatch) {
		super();
		this.serviceName = serviceName;
		this.countDownLatch = countDownLatch;
		this.serviceUp = false;
	}

	@Override
	public void run() {
		try {
			verifyService();
			serviceUp = true;
		} catch (Exception e) {
			e.printStackTrace();
			serviceUp = false;
		}finally {
			if(countDownLatch != null)
				countDownLatch.countDown();
		}
		
	}
	
	public abstract void verifyService();
	
	public boolean isServiceUp() {
		return this.serviceUp;
	}
	
	public String getServiceName() {
		return this.serviceName;
	}
	

}
