package concurrentClasses.threads.producerConsumer;

public class PCTest {

	public static void main(String[] args) throws InterruptedException {

		final ProducerConsumer producerConsumer = new ProducerConsumer();
		
		//Thread for producer
		Thread producerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producerConsumer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//Thread for consumer
		Thread consumerThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producerConsumer.consumer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
	}

}
