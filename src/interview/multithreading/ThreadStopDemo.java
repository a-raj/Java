package interview.multithreading;

import java.util.concurrent.TimeUnit;

/*
* How to stop a thread in Java?
* */
public class ThreadStopDemo {

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();

        Thread t1 = new Thread(server, "Thread - 1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(1);


        System.out.println(Thread.currentThread().getName() + " is stopping server thread");
        server.stop();

        TimeUnit.MILLISECONDS.sleep(2);

        System.out.println(Thread.currentThread().getName() + " is finished now");
    }




    private static class Server implements Runnable {
        /*
        * Since we are setting this variable from a different thread e.g. main thread,
        * it's important to mark this variable volatile, otherwise,
        * it's possible for the running thread to cache its value and never check back to main memory for updated value and running infinitely.
        * */
        private volatile boolean exit = false;

        @Override
        public void run() {

            while (!exit) {
                System.out.println("Server is running...");
            }
            System.out.println("Server is stopped");
        }
        void stop() {
            this.exit = true;
        }
    }
}
