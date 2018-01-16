package concurrentClasses.synchronizers.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	/*
	 * The key difference is that CountDownLatch separates concurrentClasses.threads into waiters and
	 * arrivers while all concurrentClasses.threads using a CyclicBarrier perform both roles.
	 * 
	 * With a latch, the waiters wait for the last arriving thread to arrive, but
	 * those arriving concurrentClasses.threads don't do any waiting themselves.
	 * 
	 * With a barrier, all
	 * concurrentClasses.threads arrive and then wait for the last to arrive.
	 * 
	 * 
	 * A better real world example would be an exam prompter who waits patiently for
	 * each student to hand in their test. Students don't wait once they complete
	 * their exams and are free to leave. Once the last student hands in the exam
	 * (or the time limit expires), the prompter stops waiting and leaves with the
	 * tests.
	 */
	
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4); 
	}
}
