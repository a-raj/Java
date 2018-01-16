package concurrentClasses.synchronizers.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {
	
	private static List<BaseService> services;
	private static CountDownLatch countDownLatch;
	
	private ApplicationStartupUtil() {}
	
	private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
	
	public static ApplicationStartupUtil getInstance() {
		return INSTANCE;
	}
	
	public static boolean checkExternalServices() throws InterruptedException {
		//initialize countDownLatch with number of services to be checked
		countDownLatch = new CountDownLatch(2);
		services = new ArrayList<>();
		
		services.add(new NetworkService(countDownLatch));
		services.add(new DatabaseService(countDownLatch));
		
		//Using thread pool to start all the services
		Executor executor = Executors.newFixedThreadPool(services.size());
		
		for(BaseService baseService : services) {
			executor.execute(baseService);
		}
		
		//Wait till all services are up
		countDownLatch.await();
		
		for(BaseService baseService : services) {
			if(!baseService.isServiceUp()) {
				return false;
			}
		}
		return true;
	}
	

}
