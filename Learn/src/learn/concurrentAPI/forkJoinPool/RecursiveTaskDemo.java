package learn.concurrentAPI.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        double[] numbers = new double[2000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (double) ((i%2) == 0 ? i : -i);
        }
        Sum task = new Sum(numbers, 0, numbers.length);
        double summation = forkJoinPool.invoke(task);
        System.out.println("Sum is: " + summation);
    }


    static class Sum extends RecursiveTask<Double>{

        private final int THRESHOLD = 500;

        double[] data;
        int start;
        int end;

        public Sum(double[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute() {
            double sum = 0;
            if (end - start < THRESHOLD) {
                for (int i = start; i < end; i++) {
                    sum += data[i];
                }
            }
            else {
                int mid = (start + end)/2;

                Sum subTaskA = new Sum(data, start, mid);
                Sum subTaskB = new Sum(data, mid, end);

                subTaskA.fork();
                subTaskB.fork();

                sum = subTaskA.join() + subTaskB.join();
            }
            return sum;
        }
    }
}
