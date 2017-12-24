package learn.concurrentAPI.synchronizers.countDownLatch;

public class TestServices {
	
	public static void main(String[] args) {
		boolean result = false;
		try {
			result = ApplicationStartupUtil.checkExternalServices();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		if(result) 
			System.out.println("All services are up and running");
		else
			System.out.println("Something bad happens");
		
	}

}
