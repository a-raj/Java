package interview.multithreading;


/*
* Producer Consumer with wait notify
* */
public class ProducerConsumer {

    public static void main(String[] args) {

        Q queue =  new Q();

        Thread consumer = new Thread(() -> {
            while (true) {
                queue.get();
            }
        });

        Thread producer = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                queue.put(i);
            }
        });

        producer.start();
        consumer.start();
    }

    static class Q {
        private int n;
        private boolean valueSet = false;

        synchronized int get() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.valueSet = false;
            System.out.println("Get: " + this.n);
            notify();
            return this.n;
        }

        synchronized void put(int n) {
            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.n = n;
            this.valueSet = true;
            System.out.println("Put: " + this.n);
            notify();
        }
    }
}
