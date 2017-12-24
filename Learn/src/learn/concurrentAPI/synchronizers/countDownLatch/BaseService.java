package learn.concurrentAPI.synchronizers.countDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * Abstract class which will be extended by other Service classes which needed to check before application Startup
 * */
public abstract class BaseService implements Runnable{
	
	private String serviceName;
	private CountDownLatch countDownLatch;
	private boolean serviceUp;
	
	//by default service up is false
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
	
	//will be implemented by other Service classes
	public abstract void verifyService();
	
	public boolean isServiceUp() {
		return this.serviceUp;
	}
	
	public String getServiceName() {
		return this.serviceName;
	}
	

}
