package interview.multithreading;


/* You are given are two threads (T1 and T2) for generation
and two threads (T3 and T4) for validation.
How do you make sure that T3 & T4 runs only after (T1 & T2).*/
public class ThreadGenerationValidation {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread t1 validates");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("thread t2 validates");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Thread T3 Runs after t1 and t2");
        });

        Thread t4 = new Thread(() -> {
            System.out.println("Thread  T4 Runs after t1 and t2");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        t4.start();

    }
}
