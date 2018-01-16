package concurrentClasses.synchronizers.phaser;

import java.util.concurrent.Phaser;

public class PhaserEvenOdd {

    private static Phaser phaser = new Phaser(2);


    public static void main(String[] args) {

        Thread thread1 = new Thread(PhaserEvenOdd::runEven);
        Thread thread2 = new Thread(PhaserEvenOdd::runOdd);
        thread1.start();
        thread2.start();
    }

    private static void runEven() {
        for (int i = 2; i <= 100; i += 2) {
            phaser.arriveAndAwaitAdvance();
            System.out.println(i);
            phaser.arriveAndAwaitAdvance();
        }

    }

    private static void runOdd() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            phaser.arriveAndAwaitAdvance();
            phaser.arriveAndAwaitAdvance();
        }
    }
}
