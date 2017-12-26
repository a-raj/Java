package learn.concurrentAPI.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        double[] data = new double[10000];

        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

        SqrtTransform sqrtTransform = new SqrtTransform(data, 0, data.length);

        forkJoinPool.invoke(sqrtTransform);

        for (double aData : data) {
            System.out.println(aData + " ");
        }

    }

   static class SqrtTransform extends RecursiveAction {

        private static final int THRESHOLD = 1000;

        private double[] data;
        private int start;
        private int end;

        SqrtTransform(double[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) < THRESHOLD) {
                for (int i = start; i < end; i++) {
                    data[i] = Math.sqrt(data[i]);
                }
            }
            else {
                int mid = (start + end)/2;

                invokeAll(new SqrtTransform(data, start, mid));
                invokeAll(new SqrtTransform(data, mid, end));
            }
        }
    }

}
