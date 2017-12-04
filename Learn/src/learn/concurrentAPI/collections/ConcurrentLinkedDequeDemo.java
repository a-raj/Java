package learn.concurrentAPI.collections;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.add("Hello");
        concurrentLinkedDeque.add("I Don't when to use you!");

    }
}
