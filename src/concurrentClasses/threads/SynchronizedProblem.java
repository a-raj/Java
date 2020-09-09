package concurrentClasses.threads;

import java.util.concurrent.TimeUnit;

public class SynchronizedProblem {

    private static synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Static Synchronized method m1");
    }

    private static synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Static Synchronized method m2");
    }

    private synchronized void m3() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Non-Static Synchronized method m3");
    }
    private synchronized void m4() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Non-Static Synchronized method m4");
    }

    private static void m5() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Non-Static Synchronized method m5");
    }

    private void m6() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Non-Static Synchronized method m6");
    }


    public static void main(String[] args) {
        SynchronizedProblem synchronizedProblem = new SynchronizedProblem();

        Thread thread1 = new Thread(SynchronizedProblem::m1);
        Thread thread2 = new Thread(SynchronizedProblem::m2);

        Thread thread3 = new Thread(synchronizedProblem::m3);
        Thread thread4 = new Thread(synchronizedProblem::m4);

        Thread thread5 = new Thread(SynchronizedProblem::m5);
        Thread thread6 = new Thread(synchronizedProblem::m6);


        thread4.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread6.start();
        thread5.start();

        /*
        * m1() and m2() take the lock on the class level
        * m3() and m4() will take lock on the object level
        * m5() and m6() will not take any lock and will run independently as there is no synchronized block
        * synchronized mean this is a critical section and only one thread should run this critical section at a time
        *
        * */

    }
}
