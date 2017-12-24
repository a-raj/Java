package learn.concurrentAPI.synchronizers.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerEvenOdd {

    private static Exchanger<Integer> exchanger = new Exchanger<>();


    public static void main(String[] args) {

        Thread thread1 = new Thread(ExchangerEvenOdd::runEven);
        Thread thread2 = new Thread(ExchangerEvenOdd::runOdd);

        thread1.start();
        thread2.start();
    }

    private static void runEven(){
        for (int i = 2; i <= 100; i+=2) {
            try {
                exchanger.exchange(i);
                System.out.println(i);
                exchanger.exchange(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void runOdd() {
        for (int i = 1; i <= 100; i+=2) {
            try {
                System.out.println(i);
                exchanger.exchange(i);
                exchanger.exchange(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


