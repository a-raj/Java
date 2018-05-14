package interview.multithreading;

import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphore {

    public static void main(String[] args) {

        Q queue = new Q();

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.get();
            }
        });

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.put(i);
            }
        });
        consumer.start();
        producer.start();
    }

    static class Q {
        int n;

        // NOTE: semaphoreConsumer is initialize with no available permits. This ensure that put execute first.
        Semaphore semaphoreConsumer = new Semaphore(0);
        Semaphore semaphoreProducer = new Semaphore(1);


        void get() {
            try {
                semaphoreConsumer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Got: " + this.n);
            semaphoreProducer.release();
        }

        void put(int n) {
            try {
                semaphoreProducer.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.n = n;
            System.out.println("Put: " + n);

            // release method : Releases a permit, increasing the number of available permits by one.
            semaphoreConsumer.release();
        }

    }
}
