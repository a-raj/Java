package threadPool;

public class TaskThread implements Runnable{

	private int taskNumber;
	
	public TaskThread(int taskNumber) {
		this.taskNumber = taskNumber;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < 100; i+=20){
			System.out.println("Task number " + taskNumber +":  "+ i + "% completed " + " Thread name " + Thread.currentThread().getName());
			
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
